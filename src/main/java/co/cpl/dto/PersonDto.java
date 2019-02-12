/******************************************************************
 *
 * This code is for the Complaints service project.
 *
 *
 * © 2018, Complaints Management All rights reserved.
 *
 *
 ******************************************************************/

// This is an example of how to implement transformer pattern for DTO objects
// please build your own model based on this
package co.cpl.dto;

import co.cpl.enums.Country;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * personDto: Data transformation object for json transformation of person object
 * @author jmunoz
 * @since 05/08/2018
 * @version 1.0.0
 */

public class PersonDto {
    private String id;
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    private String phone;
    @NotNull
    private String identification;
    private String address1;
    private String address2;
    private String city;
    private String state;
    @NotNull
    private Country country;
    private String postalCode;


    /**
     * @return the person id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @param id the person id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the person name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name the person name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the person email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * @param email the person email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the person phone
     */
    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the person phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the person identification
     */
    @JsonProperty("identification")
    public String getIdentification() {
        return identification;
    }

    /**
     * @param identification the person identification
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * @return the person address1
     */
    @JsonProperty("address_1")
    public String getAddress1() {
        return address1;
    }

    /**
     * @param address1 the person address 1
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * @return the person address2
     */
    @JsonProperty("address_2")
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 the person address 2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return the person city
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * @param city the person city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the person state
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * @param state the person state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the person country
     */
    @JsonProperty("country")
    public Country getCountry() {
        return country;
    }

    /**
     * @param country the person country
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * @return the person postalCode
     */
    @JsonProperty("postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the person postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "personDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", identification='" + identification + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country=" + country +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
