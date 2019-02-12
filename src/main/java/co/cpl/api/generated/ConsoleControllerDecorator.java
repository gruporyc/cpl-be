
package co.cpl.api.generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Retrieve the RAML API endpoints definition
 * (Generated with springmvc-raml-parser v.2.0.3)
 * 
 */
@RestController
@RequestMapping("/v1/console")
@Validated
public class ConsoleControllerDecorator
    implements ConsoleController
{

    @Autowired
    private ConsoleController consoleControllerDelegate;

    /**
     * No description
     * 
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getObject() {
        return this.consoleControllerDelegate.getObject();
    }

}
