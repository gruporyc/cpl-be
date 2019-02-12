package co.cpl.service.impl;

import co.cpl.api.generated.model.SimpleResponse;
import co.cpl.api.generated.model.User;
import co.cpl.dto.IncidenceDto;
import co.cpl.dto.UsersDto;
import co.cpl.service.APIManager;
import co.cpl.utilities.PropertyManager;
import co.cpl.utilities.RestTemplateHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Component
public class ApiManagerImpl implements APIManager {

	private RestTemplateHelper restTemplateHelper;
	private PropertyManager pm;


	public ApiManagerImpl(PropertyManager pm) {
		super();
		this.restTemplateHelper = new RestTemplateHelper(new RestTemplate());
		this.pm = pm;
	}

	@Override
	public List<UsersDto> getUsers(Long offset, Long limit) {

		Map<String,String> params = new HashMap<>();
		params.put("offset", String.valueOf(offset));
		params.put("limit", String.valueOf(limit));

        String property = pm.getProperty("cpl.users.base.endpoint");
        ResponseEntity<UsersDto[]> response = restTemplateHelper.processRequestGet(
				pm.getProperty("cpl.users.base.endpoint"), null, UsersDto[].class, params);

		if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
			return Arrays.asList(Objects.requireNonNull(response.getBody()));
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public UsersDto getUserById(String userId) {

        ResponseEntity<UsersDto> response = restTemplateHelper.processRequestGet(
				pm.getProperty("cpl.users.base.endpoint") + "/users/" + userId, UsersDto.class);

		if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
			return Objects.requireNonNull(response.getBody());
		} else {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
	}

    @Override
    public SimpleResponse deleteUser(String userId) {

        ResponseEntity<SimpleResponse> response = restTemplateHelper.processRequestGet(
                pm.getProperty("cpl.users.base.endpoint") + "/" + userId, SimpleResponse.class);

        if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
            return response.getBody();
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Integer createUser(UsersDto newUser) {

        Map<String,String> params = new HashMap<>();
        params.put("name", newUser.getName());
        params.put("last_name", newUser.getLast_name());
        params.put("email", newUser.getEmail());
        params.put("password", newUser.getPassword());
        params.put("status", String.valueOf(newUser.getStatus()));
        params.put("document_type", String.valueOf(newUser.getDocument_type()));
        params.put("document_number", String.valueOf(newUser.getDocument_number()));
        params.put("country", String.valueOf(newUser.getCountry()));
        params.put("city", String.valueOf(newUser.getCity()));
        params.put("type", String.valueOf(newUser.getType()));
        params.put("phone", newUser.getPhone());
        params.put("imei", newUser.getImei());

        ResponseEntity<Object> response = restTemplateHelper.processRequestPost(
                pm.getProperty("cpl.users.base.endpoint") + "/users", params, Object.class);
        //System.out.println("****************************Error********************* " + response.getBody().toString());
        if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
            return (Integer) response.getBody();
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_MODIFIED);
        }
    }

    @Override
    public Boolean updateUser(UsersDto newUser) {

        Map<String,String> params = new HashMap<>();
        params.put("id", newUser.getId());
        params.put("name", newUser.getName());
        params.put("last_name", newUser.getLast_name());
        params.put("email", newUser.getEmail());
        params.put("password", newUser.getPassword());
        params.put("status", String.valueOf(newUser.getStatus()));
        params.put("document_type", String.valueOf(newUser.getDocument_type()));
        params.put("document_number", String.valueOf(newUser.getDocument_number()));
        params.put("country", String.valueOf(newUser.getCountry()));
        params.put("city", String.valueOf(newUser.getCity()));
        params.put("type", String.valueOf(newUser.getType()));
        params.put("phone", newUser.getPhone());
        params.put("imei", newUser.getImei());

        ResponseEntity<Object> response = restTemplateHelper.processRequestPost(
                pm.getProperty("cpl.users.base.endpoint") + "/users_update", params, Object.class);

        if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
            return (Boolean) response.getBody();
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_MODIFIED);
        }
    }

    @Override
    public Boolean changePass(UsersDto newUser) {

      Map<String,String> params = new HashMap<>();
      params.put("id", newUser.getId());
      params.put("name", newUser.getName());
      params.put("last_name", newUser.getLast_name());
      params.put("email", newUser.getEmail());
      params.put("password", newUser.getPassword());
      params.put("status", String.valueOf(newUser.getStatus()));
      params.put("document_type", String.valueOf(newUser.getDocument_type()));
      params.put("document_number", String.valueOf(newUser.getDocument_number()));
      params.put("country", String.valueOf(newUser.getCountry()));
      params.put("city", String.valueOf(newUser.getCity()));
      params.put("type", String.valueOf(newUser.getType()));
      params.put("phone", newUser.getPhone());
      params.put("imei", newUser.getImei());

      ResponseEntity<Object> response = restTemplateHelper.processRequestPost(
              pm.getProperty("cpl.users.base.endpoint") + "/users/change_pass", params, Object.class);

      if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
        return (Boolean) response.getBody();
      } else {
        throw new HttpClientErrorException(HttpStatus.NOT_MODIFIED);
      }
    }

    @Override
    public UsersDto login(UsersDto newUser) {

      Map<String,String> params = new HashMap<>();
      //params.put("id", newUser.getId());
      params.put("name", newUser.getName());
      params.put("last_name", newUser.getLast_name());
      params.put("email", newUser.getEmail());
      params.put("password", newUser.getPassword());
      params.put("status", String.valueOf(newUser.getStatus()));
      params.put("document_type", String.valueOf(newUser.getDocument_type()));
      params.put("document_number", String.valueOf(newUser.getDocument_number()));
      params.put("country", String.valueOf(newUser.getCountry()));
      params.put("city", String.valueOf(newUser.getCity()));
      params.put("type", String.valueOf(newUser.getType()));
      params.put("phone", newUser.getPhone());
      params.put("imei", newUser.getImei());

      ResponseEntity<UsersDto> response = restTemplateHelper.processRequestPost(
              pm.getProperty("cpl.users.base.endpoint") + "/users/login", params, UsersDto.class);

      /*
      if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
        return response.getBody();
      } else {
        throw new HttpClientErrorException(HttpStatus.NOT_MODIFIED);
      }
      */

      if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
        return Objects.requireNonNull(response.getBody());
      } else {
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
      }
    }

  @Override
  public UsersDto findUserByEmail(UsersDto newUser) {
    Map<String,String> params = new HashMap<>();
    params.put("email", newUser.getEmail());
    params.put("password", newUser.getPassword());

    ResponseEntity<UsersDto> response = restTemplateHelper.processRequestPost(
            pm.getProperty("cpl.users.base.endpoint") + "/users/recover_password", params, UsersDto.class);

    if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
      return Objects.requireNonNull(response.getBody());
    } else {
      throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public IncidenceDto findIncidenceById(String id) {
    ResponseEntity<IncidenceDto> response = restTemplateHelper.processRequestGet(
            pm.getProperty("cpl.incidences.base.endpoint") + "/incidence/" + id, IncidenceDto.class);

    if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
      return Objects.requireNonNull(response.getBody());
    } else {
      throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public List<IncidenceDto> findIncidenceByIdUser(String id) {
    ResponseEntity<IncidenceDto[]> response = restTemplateHelper.processRequestGet(
            pm.getProperty("cpl.incidences.base.endpoint") + "/incidence/mys_incidences/" + id, IncidenceDto[].class);

    if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
      return Arrays.asList(Objects.requireNonNull(response.getBody()));
    } else {
      throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public List<IncidenceDto> getIncidences(int limit, int offset) {
    Map<String,String> params = new HashMap<>();
    params.put("offset", String.valueOf(offset));
    params.put("limit", String.valueOf(limit));

    String property = pm.getProperty("cpl.incidences.base.endpoint");
    ResponseEntity<IncidenceDto[]> response = restTemplateHelper.processRequestGet(
            pm.getProperty("cpl.incidences.base.endpoint") + "/incidence", null, IncidenceDto[].class, params);

    if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
      return Arrays.asList(Objects.requireNonNull(response.getBody()));
    } else {
      return new ArrayList<>();
    }
  }

  @Override
  public Boolean createIncidence(IncidenceDto newUser) {

    Map<String,Object> params = new HashMap<>();
    params.put("title", newUser.getTitle());
    params.put("description", newUser.getDescription());
    params.put("placa", newUser.getPlaca());
    params.put("date_device", newUser.getDateDevice());
    params.put("date_user", String.valueOf(newUser.getDateUser()));
    params.put("direction_gps", String.valueOf(newUser.getDirectionGps()));
    params.put("city", String.valueOf(newUser.getDirectionUser()));
    params.put("status", String.valueOf(newUser.getStatus()));
    params.put("id_user", String.valueOf(newUser.getIdUser()));
    params.put("type", newUser.getType());
    params.put("images", newUser.getImages());
    params.put("lat_capt", newUser.getDirectionGpsLat());
    params.put("lng_capt", newUser.getDirectionGpsLng());
    params.put("lat_ingre", newUser.getDirectionUserLat());
    params.put("lng_ingre", newUser.getDirectionUserLng());

    if (newUser.getImages() != null && newUser.getImages().size() > 0) {
      System.out.println(newUser.getImages().get(0).getImg());
    }

    ResponseEntity<Object> response = restTemplateHelper.processRequestPostObject(
            pm.getProperty("cpl.incidences.base.endpoint") + "/incidence", params, Object.class);
    //System.out.println("****************************Error********************* " + response.getBody().toString());
    if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
      return (Boolean) response.getBody();
    } else {
      throw new HttpClientErrorException(HttpStatus.NOT_MODIFIED);
    }
  }

  @Override
  public Boolean updateIncidence(IncidenceDto newUser) {
    Map<String,Object> params = new HashMap<>();
    params.put("id", newUser.getId());
    params.put("title", newUser.getTitle());
    params.put("description", newUser.getDescription());
    params.put("placa", newUser.getPlaca());
    params.put("date_device", newUser.getDateDevice());
    params.put("date_user", String.valueOf(newUser.getDateUser()));
    params.put("direction_gps", String.valueOf(newUser.getDirectionGps()));
    params.put("city", String.valueOf(newUser.getDirectionUser()));
    params.put("status", String.valueOf(newUser.getStatus()));
    params.put("id_user", String.valueOf(newUser.getIdUser()));
    params.put("type", newUser.getType());
    params.put("lat_capt", newUser.getDirectionGpsLat());
    params.put("lng_capt", newUser.getDirectionGpsLng());
    params.put("lat_ingre", newUser.getDirectionUserLat());
    params.put("lng_ingre", newUser.getDirectionUserLng());

    ResponseEntity<Object> response = restTemplateHelper.processRequestPostObject(
            pm.getProperty("cpl.incidences.base.endpoint") + "/incidence/update", params, Object.class);

    if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
      return (Boolean) response.getBody();
    } else {
      throw new HttpClientErrorException(HttpStatus.NOT_MODIFIED);
    }
  }

  @Override
  public void deleteIncidence(String userId) {

  }
}
