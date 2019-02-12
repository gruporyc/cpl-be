package co.cpl.api.generated;

import co.cpl.dto.IncidenceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/incidence")
@Validated
public class IncidenceControllerDecorator
        implements IncidenceController {

  @Autowired
  private IncidenceController incidenceControllerDelegate;

  /**
   * No description
   *
   */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public ResponseEntity<List<IncidenceDto>> getIncidences(
          @RequestParam(required = false, defaultValue = "0")
                  Long offset,
          @RequestParam(required = false, defaultValue = "1000000")
                  Long limit) {
    return this.incidenceControllerDelegate.getIncidences(offset, limit);
  }

  /**
   * No description
   *
   */
  @RequestMapping(value = "", method = RequestMethod.POST)
  public ResponseEntity<Object> createIncidence(
          @Valid
          @RequestBody
                  IncidenceDto user) {
    return this.incidenceControllerDelegate.createIncidence(user);
  }

  /**
   * No description
   *
   */
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public ResponseEntity<Object> updateIncidence(
          @Valid
          @RequestBody
                  IncidenceDto user) {
    return this.incidenceControllerDelegate.updateIncidence(user);
  }

  /**
   * No description
   *
   */
  @RequestMapping(value = "/{incidence-id}", method = RequestMethod.GET)
  public ResponseEntity<IncidenceDto> findIncidenceById(
          @PathVariable("incidence-id")
                  String userId) {
    return this.incidenceControllerDelegate.findIncidenceById(userId);
  }

  /**
   * No description
   *
   */
  @RequestMapping(value = "/mys_incidences/{user-id}", method = RequestMethod.GET)
  public ResponseEntity<List<IncidenceDto>> findIncidenceByIdUser(
          @PathVariable("user-id")
                  String userId) {
    return this.incidenceControllerDelegate.findIncidenceByIdUser(userId);
  }

  /**
   * No description
   *
   */
  @RequestMapping(value = "/{user-id}", method = RequestMethod.DELETE)
  public ResponseEntity<Object> deleteIncidence(
          @PathVariable("user-id")
                  String userId) {
    return this.incidenceControllerDelegate.deleteIncidence(userId);
  }
}
