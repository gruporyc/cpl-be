
package co.cpl.api.generated;

import java.util.List;
import javax.validation.Valid;
import co.cpl.api.generated.model.SimpleResponse;
import co.cpl.api.generated.model.User;
import co.cpl.dto.UsersDto;
import org.springframework.http.ResponseEntity;


/**
 * Users management
 * (Generated with springmvc-raml-parser v.2.0.3)
 *
 */
public interface UserController {


    /**
     * No description
     *
     */
    public ResponseEntity<List<UsersDto>> getUsers(Long offset, Long limit);

    /**getUserByUserId
     * No description
     *
     */
    public ResponseEntity<Object> createUser(
        @Valid
        UsersDto user);

    /**
     * No description
     *
     */
    public ResponseEntity<Object> changePass(
        @Valid
        UsersDto user);

    /**
     * No description
     *
     */
    public ResponseEntity<Object> updateUser(
            @Valid
                    UsersDto user);

    /**
     * No description
     *
     */
    public ResponseEntity<UsersDto> getUserByUserId(String userId);

    /**getUserByUserId
     * No description
     *
     */
    public ResponseEntity<UsersDto> login(
            @Valid
                    UsersDto user);

    /**getUserByUserId
     * No description
     *
     */
    public ResponseEntity<UsersDto> findUserByEmail(
            @Valid
                    UsersDto user);

    /**
     * No description
     * 
     */
    public ResponseEntity<Object> deleteUserByUserId(String userId);

}
