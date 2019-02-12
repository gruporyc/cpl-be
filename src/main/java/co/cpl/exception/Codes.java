/**
 * 
 */
package co.cpl.exception;

/**
 * <h1>Codes</h1>
 * Enum file maintained for codes. This is basically a key value pair kind of mapping.
 *
 * @author jmunoz
 */
public enum Codes {

  /** The field validation message. */
  FIELDS_VALIDATION_ERROR("app.invalidFieldsDataError", "Request contains invalid data");
  
  /** The error code. */
  private String errorCode;
  /**
   * Default (server side) error message. The UI can provide a more meaningful message based on the error code, if needed.
   */
  private String errorMessage;

  /**
   * Gets the error code.
   *
   * @return the error
   */
  public String getErrorCode() {
    return errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   * Instantiates a new codes.
   *
   * @param error
   *          the error
   */
  private Codes(String error) {
    this.errorCode = error;
  }

  /**
   * Instantiates a new codes.
   *
   * @param error
   *          the error
   */
  private Codes(String error, String errorMessage) {
    this.errorCode = error;
    this.errorMessage = errorMessage;
  }


}
