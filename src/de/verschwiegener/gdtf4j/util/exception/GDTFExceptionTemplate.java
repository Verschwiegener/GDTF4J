package de.verschwiegener.gdtf4j.util.exception;


/**
 * Exception message templates. Used to build exception with predefined message.
 */
public enum GDTFExceptionTemplate {
  /**
   * Unhandled exception.
   */
  UNHANDLED_EXCEPTION("Unhandled exception: %s"),
  /**
   * Used by {@link com.spinyowl.legui.style.font.Font}.
   */
  FAILED_TO_LOAD_FONT("Failed to initialize font. (%s)"),
  /**
   * Used by {@link StbBackedLoadableImage}.
   */
  FAILED_TO_LOAD_IMAGE("Failed to initialize image. (%s)"),
  FAILED_TO_FIND_COLOR("Failed to find color. (%s)"),
  ;

  /**
   * Exception message template.
   */
  private final String message;

  /**
   * Used to create exception templates.
   *
   * @param message message template.
   */
  GDTFExceptionTemplate(String message) {
    this.message = message;
  }

  /**
   * Error message constructor.
   *
   * @param args error message variables.
   * @return constructed message.
   */
  public String message(String... args) {
    return String.format(message, (Object[]) args);
  }

  /**
   * Used to create LeguiException with specified message and provided variables.
   *
   * @param args error message variables.
   * @return exception constructed with message template.
   */
  public GDTFException create(String... args) {
    return new GDTFException(message(args));
  }

  /**
   * Used to create LeguiException with specified message, {@link Throwable} cause and provided
   * variables.
   *
   * @param args error message variables.
   * @param e    throwable instance.
   * @return exception constructed with message template.
   */
  public GDTFException create(Throwable e, String... args) {
    return new GDTFException(message(args), e);
  }

}