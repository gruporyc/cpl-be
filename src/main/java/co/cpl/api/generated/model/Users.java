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
package co.cpl.api.generated.model;

public class Users {

    private final String id;
    private final String name;
    private final String last_name;
    private final String document_type;
    private final String document_number;
    private final String country;
    private final String city;
    private final String imei;
    private final String status;
    private final String phone;
    private final String password;
    private final String email;
    private final String type;
    private final String createdAt;
    private final String updatedAt;

    public Users(String id,
                 String name,
                 String status,
                 String last_name,
                 String document_type,
                 String document_number,
                 String country,
                 String city,
                 String imei,
                 String type,
                 String phone,
                 String password,
                 String email,
                 String createdAt,
                 String updatedAt) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.document_type = document_type;
        this.document_number = document_number;
        this.country = country;
        this.city = city;
        this.imei = imei;
        this.type = type;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getLast_name() { return last_name; }

    public String getDocument_type() { return document_type; }

    public String getDocument_number() { return document_number; }

    public String getCountry() { return country; }

    public String getCity() { return city; }

    public String getImei() { return imei; }

    public String getType() { return type; }

    public String getPhone() { return phone; }

    public String getEmail() { return email; }

    public String getPassword() { return password; }

    public static class Builder {
        private String id;
        private String name;
        private String last_name;
        private String status;
        private String country;
        private String city;
        private String imei;
        private String phone;
        private String email;
        private String password;
        private String document_type;
        private String document_number;
        private String type;
        private String createdAt;
        private String updatedAt;

        public Users.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Users.Builder setName(String name) {
            this.name = name;
            return this;
        }


        public Users.Builder setLastName(String last_name) {
            this.last_name = last_name;
            return this;
        }

        public Users.Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Users.Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Users.Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Users.Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Users.Builder setImei(String imei) {
            this.imei = imei;
            return this;
        }

        public Users.Builder setDocumentType(String document_type) {
            this.document_type = document_type;
            return this;
        }

        public Users.Builder setDocumentNumber(String document_number) {
            this.document_number = document_number;
            return this;
        }

        public Users.Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Users.Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Users.Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Users.Builder setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Users.Builder setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Users build() {
            return new Users(id, name, status, last_name, document_type, document_number, country, city, imei, type, phone, password, email, createdAt, updatedAt);
        }
    }
}
