package co.cpl.service.impl;

import co.cpl.dto.IncidenceDto;
import co.cpl.service.APIManager;
import co.cpl.service.IncidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IncidenceServiceImpl implements IncidenceService {

  @Autowired
  APIManager apiManager;

  @Override
  public IncidenceDto findIncidenceById(String id) {
    return apiManager.findIncidenceById(id);
  }

  @Override
  public List<IncidenceDto> findIncidenceByIdUser(String id) {
    return apiManager.findIncidenceByIdUser(id);
  }

  @Override
  public List<IncidenceDto> getIncidences(int limit, int offset) {
    return apiManager.getIncidences(limit, offset);
  }

  @Override
  public Boolean createIncidence(IncidenceDto usersDto) {
    return apiManager.createIncidence(usersDto);
  }

  @Override
  public Boolean updateIncidence(IncidenceDto usersDto) {
    return apiManager.updateIncidence(usersDto);
  }

  @Override
  public void deleteIncidence(String userId) {

  }
}
