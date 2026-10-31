package de.verschwiegener.gdtf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * A small GDTF file with every case the resolver handles: 16 bit channel, mirrored values, wheel with sets,
 * mode master, virtual channel, geometry references over two breaks with "Overwrite", axis without model and a
 * laser geometry
 */
final class TestGdtf {

	static final String DESCRIPTION = """
			<?xml version="1.0" encoding="UTF-8"?>
			<GDTF DataVersion="1.2">
			  <FixtureType Name="Test Spot" ShortName="TS" LongName="Test Spot Long" Manufacturer="Zeus"
			      Description="For tests" FixtureTypeID="11111111-2222-3333-4444-555555555555" Thumbnail="thumbnail"
			      RefFT="" CanHaveChildren="Yes">
			    <AttributeDefinitions>
			      <ActivationGroups>
			        <ActivationGroup Name="PanTilt"/>
			      </ActivationGroups>
			      <FeatureGroups>
			        <FeatureGroup Name="Dimmer" Pretty="Dim"><Feature Name="Dimmer"/></FeatureGroup>
			        <FeatureGroup Name="Position" Pretty="Pos"><Feature Name="PanTilt"/></FeatureGroup>
			        <FeatureGroup Name="Gobo" Pretty="Gobo"><Feature Name="Gobo"/></FeatureGroup>
			        <FeatureGroup Name="Color" Pretty="Color"><Feature Name="RGB"/></FeatureGroup>
			        <FeatureGroup Name="Control" Pretty="Ctrl"><Feature Name="Control"/></FeatureGroup>
			      </FeatureGroups>
			      <Attributes>
			        <Attribute Name="Dimmer" Pretty="Dim" Feature="Dimmer.Dimmer" PhysicalUnit="LuminousIntensity"/>
			        <Attribute Name="Pan" Pretty="P" ActivationGroup="PanTilt" Feature="Position.PanTilt" PhysicalUnit="Angle"/>
			        <Attribute Name="Gobo1" Pretty="G1" Feature="Gobo.Gobo"/>
			        <Attribute Name="ColorAdd_R" Pretty="R" Feature="Color.RGB" PhysicalUnit="ColorComponent" Color="0.64,0.33,21.26"/>
			        <Attribute Name="Control1" Pretty="Ctrl1" Feature="Control.Control"/>
			      </Attributes>
			    </AttributeDefinitions>
			    <Wheels>
			      <Wheel Name="Gobo1">
			        <Slot Name="Open" Color="0.3127,0.3290,100.0"/>
			        <Slot Name="Dots" Color="0.3127,0.3290,100.0" MediaFileName="dots"/>
			      </Wheel>
			    </Wheels>
			    <PhysicalDescriptions>
			      <Emitters>
			        <Emitter Name="Red" Color="0.7,0.3,10" DominantWaveLength="630"/>
			      </Emitters>
			      <Filters/>
			      <ColorSpace Name="Default" Mode="sRGB"/>
			      <AdditionalColorSpaces/>
			      <Gamuts/>
			      <DMXProfiles/>
			      <CRIs/>
			      <Connectors/>
			      <Properties/>
			    </PhysicalDescriptions>
			    <Models>
			      <Model Name="Base" Length="0.3" Width="0.3" Height="0.1" PrimitiveType="Undefined" File="base"/>
			      <Model Name="Head" Length="0.2" Width="0.2" Height="0.3" PrimitiveType="Cube"/>
			    </Models>
			    <Geometries>
			      <Geometry Name="Base" Model="Base" Position="{1,0,0,0}{0,1,0,0}{0,0,1,0}{0,0,0,1}">
			        <Axis Name="Yoke" Position="{1,0,0,0}{0,1,0,0}{0,0,1,-0.1}{0,0,0,1}">
			          <Beam Name="Beam" Model="Head" BeamAngle="20" Position="{1,0,0,0}{0,1,0,0}{0,0,1,-0.2}{0,0,0,1}"/>
			          <Laser Name="Laser" Position="{1,0,0,0.5}{0,1,0,0}{0,0,1,0}{0,0,0,1}"/>
			        </Axis>
			        <GeometryReference Name="Pixel 1" Geometry="Pixel" Position="{1,0,0,0}{0,1,0,0}{0,0,1,0}{0,0,0,1}">
			          <Break DMXBreak="1" DMXOffset="20"/>
			          <Break DMXBreak="2" DMXOffset="1"/>
			          <Break DMXBreak="1" DMXOffset="30"/>
			        </GeometryReference>
			        <GeometryReference Name="Pixel 2" Geometry="Pixel" Position="{1,0,0,0.1}{0,1,0,0}{0,0,1,0}{0,0,0,1}">
			          <Break DMXBreak="1" DMXOffset="23"/>
			          <Break DMXBreak="2" DMXOffset="4"/>
			          <Break DMXBreak="1" DMXOffset="31"/>
			        </GeometryReference>
			      </Geometry>
			      <Geometry Name="Pixel" Position="{1,0,0,0}{0,1,0,0}{0,0,1,0}{0,0,0,1}">
			        <Beam Name="PixelBeam" Position="{1,0,0,0}{0,1,0,0}{0,0,1,0}{0,0,0,1}"/>
			      </Geometry>
			    </Geometries>
			    <DMXModes>
			      <DMXMode Name="Standard" Geometry="Base" Description="Standard mode">
			        <DMXChannels>
			          <DMXChannel DMXBreak="1" Offset="1,2" InitialFunction="Base_Dimmer.Dimmer.Dimmer" Highlight="65535/2" Geometry="Base">
			            <LogicalChannel Attribute="Dimmer" Master="Grand">
			              <ChannelFunction Name="Dimmer" Attribute="Dimmer" DMXFrom="0/1" Default="128/1" PhysicalFrom="0" PhysicalTo="100"/>
			            </LogicalChannel>
			          </DMXChannel>
			          <DMXChannel DMXBreak="1" Offset="3" Highlight="None" Geometry="Yoke">
			            <LogicalChannel Attribute="Pan" Snap="Yes">
			              <ChannelFunction Name="Pan" Attribute="Pan" DMXFrom="0/1" Default="128/1" PhysicalFrom="-270" PhysicalTo="270"/>
			            </LogicalChannel>
			          </DMXChannel>
			          <DMXChannel DMXBreak="1" Offset="4" InitialFunction="Beam_Gobo1.Gobo1.Spin" Geometry="Beam">
			            <LogicalChannel Attribute="Gobo1">
			              <ChannelFunction Default="0/1" Name="Gobo" Attribute="Gobo1" DMXFrom="0/1" Wheel="Gobo1">
			                <ChannelSet Name="Open" DMXFrom="0/1" WheelSlotIndex="1"/>
			                <ChannelSet Name="Dots" DMXFrom="10/1" WheelSlotIndex="2"/>
			              </ChannelFunction>
			              <ChannelFunction Name="Spin" Attribute="Gobo1" DMXFrom="128/1" Default="200/1"/>
			            </LogicalChannel>
			          </DMXChannel>
			          <DMXChannel DMXBreak="1" Offset="5" Geometry="Base">
			            <LogicalChannel Attribute="Control1">
			              <ChannelFunction Default="0/1" Name="Low" Attribute="Control1" DMXFrom="0/1" ModeMaster="Base_Dimmer" ModeFrom="0/1" ModeTo="127/1"/>
			              <ChannelFunction Default="0/1" Name="High" Attribute="Control1" DMXFrom="0/1" ModeMaster="Base_Dimmer" ModeFrom="128/1" ModeTo="255/1"/>
			            </LogicalChannel>
			          </DMXChannel>
			          <DMXChannel DMXBreak="1" Offset="None" Geometry="Yoke">
			            <LogicalChannel Attribute="Control1">
			              <ChannelFunction Attribute="Control1" DMXFrom="0/2" Default="65535/2"/>
			            </LogicalChannel>
			          </DMXChannel>
			          <DMXChannel DMXBreak="1" Offset="1" Geometry="Pixel">
			            <LogicalChannel Attribute="ColorAdd_R">
			              <ChannelFunction Default="0/1" Name="Red" Attribute="ColorAdd_R" DMXFrom="0/1" Emitter="Red" Wheel="Missing"/>
			            </LogicalChannel>
			          </DMXChannel>
			          <DMXChannel DMXBreak="2" Offset="1" Geometry="Pixel">
			            <LogicalChannel Attribute="Dimmer">
			              <ChannelFunction Default="0/1" Name="Dimmer" Attribute="Dimmer" DMXFrom="0/1"/>
			            </LogicalChannel>
			          </DMXChannel>
			          <DMXChannel DMXBreak="Overwrite" Offset="1" Geometry="Pixel">
			            <LogicalChannel Attribute="Control1">
			              <ChannelFunction Default="0/1" Name="Control" Attribute="Control1" DMXFrom="0/1"/>
			            </LogicalChannel>
			          </DMXChannel>
			        </DMXChannels>
			        <Relations>
			          <Relation Name="Virtual" Master="Yoke_Control1" Follower="Base_Dimmer.Dimmer.Dimmer" Type="Multiply"/>
			        </Relations>
			      </DMXMode>
			    </DMXModes>
			    <Revisions>
			      <Revision Text="First" Date="2024-01-01T10:00:00" UserID="0"/>
			    </Revisions>
			  </FixtureType>
			</GDTF>
			""";

	private TestGdtf() {
	}

	/**
	 * @return The test fixture with thumbnail, two model files and a gobo image
	 */
	static byte[] archive() {
		Map<String, byte[]> files = new LinkedHashMap<>();
		files.put("description.xml", DESCRIPTION.getBytes(StandardCharsets.UTF_8));
		files.put("thumbnail.png", new byte[] { 1 });
		files.put("thumbnail.svg", new byte[] { 2 });
		files.put("models/gltf/base.glb", new byte[] { 3 });
		files.put("models/3ds/base.3ds", new byte[] { 4 });
		files.put("wheels/dots.png", new byte[] { 5 });
		return zip(files);
	}

	static byte[] zip(Map<String, byte[]> files) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try (ZipOutputStream zip = new ZipOutputStream(out)) {
			for (Map.Entry<String, byte[]> file : files.entrySet()) {
				zip.putNextEntry(new ZipEntry(file.getKey()));
				zip.write(file.getValue());
				zip.closeEntry();
			}
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		return out.toByteArray();
	}

	static byte[] withDescription(String description) {
		return zip(Map.of("description.xml", description.getBytes(StandardCharsets.UTF_8)));
	}

}
