# GDTF4J

Liest GDTF-Dateien (General Device Type Format, DIN SPEC 15800) in ein
unveränderliches, aufgelöstes Modell. Java 21, keine Abhängigkeiten außer
Jakarta XML Binding.

```java
GdtfArchive archive = GdtfReader.create().read(Path.of("Robe@Robin Spiider.gdtf"));
GdtfFixtureType type = archive.fixtureType();

for (GdtfDmxMode mode : type.modes()) {
	System.out.println(mode.name() + ": " + mode.footprint(1) + " Kanäle");
	for (GdtfDmxChannel channel : mode.channels())
		for (GdtfChannelFunction function : channel.functions())
			System.out.println("  " + channel.name() + " " + function.attribute()
					+ " " + function.dmxFrom() + ".." + function.dmxTo());
}
```

## Eigenschaften

- **Liest aus Streams, im Speicher.** Nichts wird auf die Festplatte entpackt.
  Weitere Dateien des Archivs (Modelle, Rad-Bilder, Thumbnail) über
  `GdtfArchive.openResource()`, `modelFiles()`, `wheelImage()` und
  `thumbnailFiles()`.
- **Kein globaler Zustand.** Kein `Locale.setDefault`, keine statischen
  veränderlichen Felder. Ein `GdtfReader` kann von mehreren Threads zugleich
  benutzt werden, das Ergebnis ist unveränderlich.
- **Aufgelöst:**
  - DMX-Werte liegen in der Auflösung ihres Kanals vor (1 bis 4 Bytes), auch
    `"128/1"` auf einem 16-Bit-Kanal. Standard ist Byte-Mirroring, `"255/1s"`
    verschiebt (siehe `DmxValue`).
  - `dmxTo` von ChannelFunctions und ChannelSets ist berechnet, Funktionen mit
    `ModeMaster` werden pro Bereich getrennt behandelt.
  - Wheels, Emitter und Filter sind direkt als Objekte verlinkt.
  - Kanäle referenzierter Geometrien (Multi-Cell, `GeometryReference`) sind pro
    Referenz ausmultipliziert, mit ihrem Break und ihren Offsets.
  - Der Default-Wert eines Kanals kommt aus seiner `InitialFunction`.
- **Tolerant mit echten Dateien.** Abweichungen, die das Ergebnis nicht
  verfälschen (unbekannte Verweise, kaputte Farben, Füllbytes nach dem
  XML, Geometrien ohne Namen), landen in `GdtfArchive.warnings()`. Fehler,
  die das Ergebnis falsch machen würden, enden in einer `GdtfException` mit
  dem betroffenen Element, z. B.
  `DMXMode Standard, DMXChannel Beam_Dimmer Offset: not a number: x`.
- **Sicher für fremde Dateien:** keine DOCTYPEs und externen Entities, Grenze
  für die entpackte Größe (`withMaxSize`).
- Strenge Prüfung gegen das Schema mit `GdtfReader.create().validating(true)`.

Längen sind in Metern, Winkel in Grad, wie in GDTF. Matrizen (`GdtfMatrix`)
stehen zeilenweise wie in der Datei, die Verschiebung ist die vierte Spalte.

## Aufbau

| Package | Inhalt |
|---|---|
| `de.verschwiegener.gdtf` | `GdtfReader`, `GdtfArchive`, `GdtfException` |
| `de.verschwiegener.gdtf.model` | das aufgelöste Modell (Records) |
| `de.verschwiegener.gdtf.xml` | JAXB-Klassen, beim Build aus `gdtf.xsd` erzeugt, nicht von Hand ändern |

Das Schema liegt unter `src/main/resources/de/verschwiegener/gdtf/gdtf.xsd`.
Es ist das GDTF-1.2-Schema mit zwei Korrekturen, die im Kopf der Datei
stehen.

## Bauen und testen

```bash
mvn test
# zusätzlich mit echten Dateien, z. B. von GDTF-Share:
mvn test -Dgdtf.samples=/pfad/zu/gdtfs
```

Der Test mit echten Dateien liest jede `.gdtf` im Ordner, prüft Footprints
gegen Kanalzahlen im Mode-Namen und die Wertebereiche aller Funktionen.
