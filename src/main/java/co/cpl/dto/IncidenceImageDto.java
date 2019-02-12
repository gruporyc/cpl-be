package co.cpl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IncidenceImageDto {

  private String id;
  private String idIncidence;
  private String img;
  private String url;
  private String urlDisplay;
  private String createdAt;
  private String updatedAt;

  @JsonProperty("id")
  public String getId() { return id;  }
  public void setId(String id) { this.id = id; }

  @JsonProperty("id_incidence")
  public String getIdIncidence() { return idIncidence;  }
  public void setIdIncidence(String idIncidence) { this.idIncidence = idIncidence; }

  @JsonProperty("img")
  public String getImg() { return img;  }
  public void setImg(String img) { this.img = img;  }

  @JsonProperty("url")
  public String getUrl() { return url;  }
  public void setUrl(String url) { this.url = url; }

  @JsonProperty("url_display")
  public String getUrlDisplay() { return urlDisplay;  }
  public void setUrlDisplay(String urlDisplay) { this.urlDisplay = urlDisplay; }

  @JsonProperty("createDate")
  public String getCreateDate() { return createdAt; }
  public void setCreateDate(String createDate) { this.createdAt = createDate; }

  @JsonProperty("updatedDate")
  public String getUpdateDate() { return updatedAt;  }
  public void setUpdateDate(String updateDate) { this.updatedAt = updateDate;  }

  @Override
  public String toString() {
    return "IncidenceImageDto{" +
            "id='" + id + '\'' +
            ", id_incidence='" + idIncidence + '\'' +
            ", url='" + url + '\'' +
            ", url_display='" + urlDisplay + '\'' +
            ", createDate='" + createdAt + '\'' +
            ", updateDate='" + updatedAt + '\'' +
            '}';
  }
}
