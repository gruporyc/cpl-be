/******************************************************************
 *
 * This code is for the Pappking service project.
 *
 *
 * © 2018, Pappking Management All rights reserved.
 *
 *
 ******************************************************************/
package co.cpl.dto;

import co.cpl.enums.Currency;
import co.cpl.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;


/**
 * PaymentRequestDto: Data transformation object for json transformation of payment request object
 * @author jmunoz
 * @since 05/08/2018
 * @version 1.0.0
 */
public class LoadRequestDto {
    @NotNull
    private float amount;
    @NotNull
    private Currency currency;
    @NotNull
    private PersonDto buyer;
    @NotNull
    private PaymentMethod method;
    private String financialInstituteCode;
    private String dni;

    /**
     * @return the payment request amount
     */
    @JsonProperty("amount")
    public float getAmount() {
        return amount;
    }

    /**
     * @param amount the payment request amount
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }

    /**
     * @return the payment request currency
     */
    @JsonProperty("currency")
    public Currency getCurrency() {
        return currency;
    }

    /**
     * @param currency the payment request currency
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * @return the payment request buyer
     */
    @JsonProperty("buyer")
    public PersonDto getBuyer() {
        return buyer;
    }

    /**
     * @param buyer the payment request buyer
     */
    public void setBuyer(PersonDto buyer) {
        this.buyer = buyer;
    }

    /**
     * @return the payment request method
     */
    @JsonProperty("method")
    public PaymentMethod getMethod() {
        return method;
    }

    /**
     * @param method the payment request method
     */
    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    /**
     * @return the payment request financial institute code
     */
    @JsonProperty("financial_institute_code")
    public String getFinancialInstituteCode() {
        return financialInstituteCode;
    }

    /**
     * @param financialInstituteCode the payment request financial institute code
     */
    public void setFinancialInstituteCode(String financialInstituteCode) {
        this.financialInstituteCode = financialInstituteCode;
    }

    /**
     * @return the payment request dni
     */
    @JsonProperty("dni")
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the payment request dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "LoadRequestDto{" +
                "amount=" + amount +
                ", currency=" + currency +
                ", buyer=" + buyer +
                ", method=" + method +
                ", financialInstituteCode='" + financialInstituteCode + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
