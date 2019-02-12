
package co.cpl.api.generated.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Error implements Serializable
{

    final static long serialVersionUID = 180310937531845483L;
    /**
     * error code assigned
     * 
     */
    protected String code;
    /**
     * Error description
     * 
     */
    protected String message;

    /**
     * Creates a new Error.
     * 
     */
    public Error() {
        super();
    }

    /**
     * Creates a new Error.
     * 
     */
    public Error(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    /**
     * Returns the code.
     * 
     * @return
     *     code
     */
    @NotNull
    public String getCode() {
        return code;
    }

    /**
     * Set the code.
     * 
     * @param code
     *     the new code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * With the code.
     * 
     * @param code
     *     the new code
     */
    public Error withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Returns the message.
     * 
     * @return
     *     message
     */
    @NotNull
    public String getMessage() {
        return message;
    }

    /**
     * Set the message.
     * 
     * @param message
     *     the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * With the message.
     * 
     * @param message
     *     the new message
     */
    public Error withMessage(String message) {
        this.message = message;
        return this;
    }

    public int hashCode() {
        return new HashCodeBuilder().append(code).append(message).toHashCode();
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (this.getClass()!= other.getClass()) {
            return false;
        }
        Error otherObject = ((Error) other);
        return new EqualsBuilder().append(code, otherObject.code).append(message, otherObject.message).isEquals();
    }

    public String toString() {
        return new ToStringBuilder(this).append("code", code).append("message", message).toString();
    }

}
