package co.cpl.service;

import co.cpl.dto.IncidenceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IncidenceService {

  IncidenceDto findIncidenceById(String id);

  List<IncidenceDto> findIncidenceByIdUser(String id);

  List<IncidenceDto> getIncidences(int limit, int offset);

  Boolean createIncidence(IncidenceDto usersDto);

  Boolean updateIncidence(IncidenceDto usersDto);

  void deleteIncidence(String userId);
}
