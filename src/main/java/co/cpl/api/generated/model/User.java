
package co.cpl.api.generated.model;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class User implements Serializable
{

    final static long serialVersionUID = 2140156895807647835L;
    /**
     * Universal identifier for users
     * 
     */
    protected String id;
    /**
     * User full name
     * 
     */
    protected String name;
    /**
     * Universal identifier for status
     * 
     */
    protected Long status;
    /**
     * User phone with local and global codes
     * 
     */
    protected String phone;
    /**
     * Cration date and time
     * 
     */
    protected String createdAt;
    /**
     * Update date and time
     * 
     */
    protected String updatedAt;

    /**
     * Creates a new User.
     * 
     */
    public User() {
        super();
    }

    /**
     * Creates a new User.
     * 
     */
    public User(String id, String name, Long status, String phone, String createdAt, String updatedAt) {
        super();
        this.id = id;
        this.name = name;
        this.status = status;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Returns the id.
     * 
     * @return
     *     id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the id.
     * 
     * @param id
     *     the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * With the id.
     * 
     * @param id
     *     the new id
     */
    public User withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the name.
     * 
     * @return
     *     name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name.
     * 
     * @param name
     *     the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * With the name.
     * 
     * @param name
     *     the new name
     */
    public User withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Returns the status.
     * 
     * @return
     *     status
     */
    public Long getStatus() {
        return status;
    }

    /**
     * Set the status.
     * 
     * @param status
     *     the new status
     */
    public void setStatus(Long status) {
        this.status = status;
    }

    /**
     * With the status.
     * 
     * @param status
     *     the new status
     */
    public User withStatus(Long status) {
        this.status = status;
        return this;
    }

    /**
     * Returns the phone.
     * 
     * @return
     *     phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the phone.
     * 
     * @param phone
     *     the new phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * With the phone.
     * 
     * @param phone
     *     the new phone
     */
    public User withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Returns the createdAt.
     * 
     * @return
     *     createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the createdAt.
     * 
     * @param createdAt
     *     the new createdAt
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * With the createdAt.
     * 
     * @param createdAt
     *     the new createdAt
     */
    public User withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Returns the updatedAt.
     * 
     * @return
     *     updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Set the updatedAt.
     * 
     * @param updatedAt
     *     the new updatedAt
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * With the updatedAt.
     * 
     * @param updatedAt
     *     the new updatedAt
     */
    public User withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name).append(status).append(phone).append(createdAt).append(updatedAt).toHashCode();
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
        User otherObject = ((User) other);
        return new EqualsBuilder().append(id, otherObject.id).append(name, otherObject.name).append(status, otherObject.status).append(phone, otherObject.phone).append(createdAt, otherObject.createdAt).append(updatedAt, otherObject.updatedAt).isEquals();
    }

    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("status", status).append("phone", phone).append("createdAt", createdAt).append("updatedAt", updatedAt).toString();
    }

}
