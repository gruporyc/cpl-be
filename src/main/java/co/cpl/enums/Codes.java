package co.cpl.enums;

public enum Codes {

    IDENTIFICATION_CANNOT_BE_NULL("app.invalidFieldsDataError", "identification cannot be null"),
    BUYER_CANNOT_BE_NULL("app.invalidFieldsDataError", "buyer cannot be null"),
    NAME_CANNOT_BE_NULL("app.invalidFieldsDataError", "name cannot be null"),
    AMOUNT_CANNOT_BE_NULL("app.invalidFieldsDataError", "amount cannot be null"),
    CURRENCY_CANNOT_BE_NULL("app.invalidFieldsDataError", "currency cannot be null"),
    METHOD_CANNOT_BE_NULL("app.invalidFieldsDataError", "payment method cannot be null"),
    SERVICE_ID_CANNOT_BE_NULL("app.invalidFieldsDataError", "service id cannot be null"),
    CUSTOMER_ID_CANNOT_BE_NULL("app.invalidFieldsDataError", "customer id cannot be null");
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
