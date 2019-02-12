package co.cpl.api.generated;

import co.cpl.dto.IncidenceDto;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

public interface IncidenceController {

  /**
   * No description
   *
   */
  public ResponseEntity<List<IncidenceDto>> getIncidences(Long offset, Long limit);


  /**
   * No description
   *
   */
  public ResponseEntity<Object> createIncidence(
          @Valid
                  IncidenceDto user);


  /**
   * No description
   *
   */
  public ResponseEntity<Object> updateIncidence(
          @Valid
                  IncidenceDto user);

  /**
   * No description
   *
   */
  public ResponseEntity<IncidenceDto> findIncidenceById(String userId);

  /**
   * No description
   *
   */
  public ResponseEntity<List<IncidenceDto>> findIncidenceByIdUser(String userId);

  /**
   * No description
   *
   */
  public ResponseEntity<Object> deleteIncidence(String userId);
}
