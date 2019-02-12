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

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * PaymentRequestDto: Data transformation object for json transformation of payment request object
 * @author jmunoz
 * @since 05/08/2018
 * @version 1.0.0
 */
public class UsersDto {

    private  String id;
    private  String name;
    private  String last_name;
    private  String document_type;
    private  String document_number;
    private  String country;
    private  String city;
    private  String imei;
    private  String status;
    private  String phone;
    private  String email;
    private  String password;
    private  String type;
    private  String createDate;
    private  String updateDate;

    @JsonProperty("id")
    public String getId() { return id;  }
    public void setId(String id) { this.id = id; }

    @JsonProperty("name")
    public String getName() { return name;  }
    public void setName(String name) { this.name = name;  }

    @JsonProperty("last_name")
    public String getLast_name() { return last_name;  }
    public void setLast_name(String last_name) { this.last_name = last_name; }

    @JsonProperty("password")
    public String getPassword() { return password;  }
    public void setPassword(String password) { this.password = password; }

    @JsonProperty("document_type")
    public String getDocument_type() { return document_type; }
    public void setDocument_type(String document_type) { this.document_type = document_type; }

    @JsonProperty("document_number")
    public String getDocument_number() { return document_number; }
    public void setDocument_number(String document_number) { this.document_number = document_number; }

    @JsonProperty("country")
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    @JsonProperty("city")
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    @JsonProperty("imei")
    public String getImei() { return imei; }
    public void setImei(String imei) { this.imei = imei; }

    @JsonProperty("type")
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @JsonProperty("status")
    public String getStatus() { return status;  }
    public void setStatus(String status) { this.status = status;  }

    @JsonProperty("phone")
    public String getPhone() { return phone;  }
    public void setPhone(String phone) { this.phone = phone;  }

    @JsonProperty("email")
    public String getEmail() { return email;  }
    public void setEmail(String email) { this.email = email;  }

    @JsonProperty("createDate")
    public String getCreateDate() { return createDate; }
    public void setCreateDate(String createDate) { this.createDate = createDate; }


    @JsonProperty("updatedDate")
    public String getUpdateDate() { return updateDate;  }
    public void setUpdateDate(String updateDate) { this.updateDate = updateDate;  }

    @Override
    public String toString() {
        return "UsersDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", last_name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", document_type='" + document_type + '\'' +
                ", document_number='" + document_number + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", imei='" + imei + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                '}';
    }
}
