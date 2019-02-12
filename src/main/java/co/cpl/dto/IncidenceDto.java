package co.cpl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class IncidenceDto {

    private String id;
    private String id_user;
    private String title;
    private String type;
    private String description;
    private String placa;
    private String date_device;
    private String date_user;
    private String direction_gps;
    private Double direction_gps_lat;
    private Double direction_gps_lng;
    private String direction_user;
    private Double direction_user_lat;
    private Double direction_user_lng;
    private String status;
    private String createdAt;
    private String updatedAt;
    private List<IncidenceImageDto> images;

    @JsonProperty("id")
    public String getId() { return id;  }
    public void setId(String id) { this.id = id; }

    @JsonProperty("id_user")
    public String getIdUser() { return id_user;  }
    public void setIdUser(String id_user) { this.id_user = id_user; }

    @JsonProperty("type")
    public String getType() { return type;  }
    public void setType(String type) { this.type = type;  }

    @JsonProperty("title")
    public String getTitle() { return title;  }
    public void setTitle(String title) { this.title = title;  }

    @JsonProperty("description")
    public String getDescription() { return description;  }
    public void setDescription(String description) { this.description = description; }

    @JsonProperty("placa")
    public String getPlaca() { return placa;  }
    public void setPlaca(String placa) { this.placa = placa; }

    @JsonProperty("date_device")
    public String getDateDevice() { return date_device; }
    public void setDateDevice(String date_device) { this.date_device = date_device; }

    @JsonProperty("date_user")
    public String getDateUser() { return date_user; }
    public void setDateUser(String date_user) { this.date_user = date_user; }

    @JsonProperty("direction_gps")
    public String getDirectionGps() { return direction_gps; }
    public void setDirectionGps(String direction_gps) { this.direction_gps = direction_gps; }

    @JsonProperty("lat_capt")
    public Double getDirectionGpsLat() { return direction_gps_lat; }
    public void setDirectionGpsLat(Double direction_gps_lat) { this.direction_gps_lat = direction_gps_lat; }

    @JsonProperty("lng_capt")
    public Double getDirectionGpsLng() { return direction_gps_lng; }
    public void setDirectionGpsLng(Double direction_gps_lng) { this.direction_gps_lng = direction_gps_lng; }

    @JsonProperty("city")
    public String getDirectionUser() { return direction_user; }
    public void setDirectionUser(String direction_user) { this.direction_user = direction_user; }

    @JsonProperty("lat_ingre")
    public Double getDirectionUserLat() { return direction_user_lat; }
    public void setDirectionUserLat(Double direction_user_lat) { this.direction_user_lat = direction_user_lat; }

    @JsonProperty("lng_ingre")
    public Double getDirectionUserLng() { return direction_user_lng; }
    public void setDirectionUserLng(Double direction_user_lng) { this.direction_user_lng = direction_user_lng; }

    @JsonProperty("status")
    public String getStatus() { return status;  }
    public void setStatus(String status) { this.status = status;  }

    @JsonProperty("images")
    public List<IncidenceImageDto> getImages() { return images;  }
    public void setImages(List<IncidenceImageDto> images) { this.images = images; }

    @JsonProperty("createDate")
    public String getCreateDate() { return createdAt; }
    public void setCreateDate(String createDate) { this.createdAt = createDate; }


    @JsonProperty("updatedDate")
    public String getUpdateDate() { return updatedAt;  }
    public void setUpdateDate(String updateDate) { this.updatedAt = updateDate;  }

    @Override
    public String toString() {
        return "IncidenceDto{" +
                "id='" + id + '\'' +
                ", id_user='" + id_user + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", placa='" + placa + '\'' +
                ", date_device='" + date_device + '\'' +
                ", date_user='" + date_user + '\'' +
                ", direction_gps='" + direction_gps + '\'' +
                ", direction_user='" + direction_user + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", createDate='" + createdAt + '\'' +
                ", updateDate='" + updatedAt + '\'' +
                '}';
    }
}
