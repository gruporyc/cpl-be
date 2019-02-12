/******************************************************************
 *
 * This code is for the Complaints service project.
 *
 *
 * © 2018, Complaints Management All rights reserved.
 *
 *
 ******************************************************************/

// This is an example of how to implement builder pattern for domain objects
// please build your own model based on this
package co.cpl.domain;

public class Load {

    private final String id;
    private final String customerId;
    private final float amount;
    private final String currency;
    private final String payerName;
    private final String payerCardLastDigits;
    private final String method;
    private final String orderId;
    private final String transactionId;
    private final String status;
    private final String networkCode;
    private final String networkMessage;
    private final String trazabilityCode;
    private final String responseCode;
    private final String bankUrl;
    private final String receiptUrl;
    private final String country;
    private final String createdAt;
    private final String updatedAt;


    public Load(String id,
                   String customerId,
                   float amount,
                   String currency,
                   String payerName,
                   String payerCardLastDigits,
                   String method,
                   String orderId,
                   String transactionId,
                   String status,
                   String networkCode,
                   String networkMessage,
                   String trazabilityCode,
                   String responseCode,
                   String bankUrl,
                   String receiptUrl,
                   String country,
                   String createdAt,
                   String updatedAt) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.currency = currency;
        this.payerName = payerName;
        this.payerCardLastDigits = payerCardLastDigits;
        this.method = method;
        this.orderId = orderId;
        this.transactionId = transactionId;
        this.status = status;
        this.networkCode = networkCode;
        this.networkMessage = networkMessage;
        this.trazabilityCode = trazabilityCode;
        this.responseCode = responseCode;
        this.bankUrl = bankUrl;
        this.receiptUrl = receiptUrl;
        this.country = country;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public float getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPayerName() {
        return payerName;
    }

    public String getPayerCardLastDigits() {
        return payerCardLastDigits;
    }

    public String getMethod() {
        return method;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getStatus() {
        return status;
    }

    public String getNetworkCode() {
        return networkCode;
    }

    public String getNetworkMessage() {
        return networkMessage;
    }

    public String getTrazabilityCode() {
        return trazabilityCode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getBankUrl() {
        return bankUrl;
    }

    public String getReceiptUrl() {
        return receiptUrl;
    }

    public String getCountry() {
        return country;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public static class Builder {
        private String id;
        private String customerId;
        private float amount;
        private String currency;
        private String payerName;
        private String payerCardLastDigits;
        private String method;
        private String orderId;
        private String transactionId;
        private String status;
        private String networkCode;
        private String networkMessage;
        private String trazabilityCode;
        private String responseCode;
        private String bankUrl;
        private String receiptUrl;
        private String country;
        private String createdAt;
        private String updatedAt;

        public Load.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Load.Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Load.Builder setAmount(float amount) {
            this.amount = amount;
            return this;
        }

        public Load.Builder setCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Load.Builder setPayerName(String payerName) {
            this.payerName = payerName;
            return this;
        }

        public Load.Builder setPayerCardLastDigits(String payerCardLastDigits) {
            this.payerCardLastDigits = payerCardLastDigits;
            return this;
        }

        public Load.Builder setMethod(String method) {
            this.method = method;
            return this;
        }

        public Load.Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Load.Builder setTransactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Load.Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Load.Builder setNetworkCode(String networkCode) {
            this.networkCode = networkCode;
            return this;
        }

        public Load.Builder setNetworkMessage(String networkMessage) {
            this.networkMessage = networkMessage;
            return this;
        }

        public Load.Builder setTrazabilityCode(String trazabilityCode) {
            this.trazabilityCode = trazabilityCode;
            return this;
        }

        public Load.Builder setResponseCode(String responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        public Load.Builder setBankUrl(String bankUrl) {
            this.bankUrl = bankUrl;
            return this;
        }

        public Load.Builder setReceiptUrl(String receiptUrl) {
            this.receiptUrl = receiptUrl;
            return this;
        }

        public Load.Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Load.Builder setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Load.Builder setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Load build() {
            return new Load(id, customerId, amount, currency, payerName, payerCardLastDigits, method, orderId,
                    transactionId, status, networkCode, networkMessage, trazabilityCode, responseCode, bankUrl,
                    receiptUrl, country, createdAt, updatedAt);
        }
    }
}
