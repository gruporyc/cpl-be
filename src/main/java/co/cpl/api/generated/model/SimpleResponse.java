
package co.cpl.api.generated.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SimpleResponse implements Serializable
{

    final static long serialVersionUID = 2014568115505079256L;
    /**
     * Operation status
     * 
     */
    protected Boolean success;
    /**
     * Additional Message
     * 
     */
    protected String message;

    /**
     * Creates a new SimpleResponse.
     * 
     */
    public SimpleResponse() {
        super();
    }

    /**
     * Creates a new SimpleResponse.
     * 
     */
    public SimpleResponse(Boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    /**
     * Returns the success.
     * 
     * @return
     *     success
     */
    @NotNull
    public Boolean getSuccess() {
        return success;
    }

    /**
     * Set the success.
     * 
     * @param success
     *     the new success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * With the success.
     * 
     * @param success
     *     the new success
     */
    public SimpleResponse withSuccess(Boolean success) {
        this.success = success;
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
    public SimpleResponse withMessage(String message) {
        this.message = message;
        return this;
    }

    public int hashCode() {
        return new HashCodeBuilder().append(success).append(message).toHashCode();
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
        SimpleResponse otherObject = ((SimpleResponse) other);
        return new EqualsBuilder().append(success, otherObject.success).append(message, otherObject.message).isEquals();
    }

    public String toString() {
        return new ToStringBuilder(this).append("success", success).append("message", message).toString();
    }

}
