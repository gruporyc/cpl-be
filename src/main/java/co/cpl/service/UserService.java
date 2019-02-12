package co.cpl.service;

import co.cpl.api.generated.model.SimpleResponse;
import co.cpl.api.generated.model.User;
import co.cpl.dto.UsersDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    List<UsersDto> getUsers(Long offset, Long limit);

    UsersDto getUserById(String userId);

    SimpleResponse deleteUser(String userId);

    Integer createUser(UsersDto newUser);

    Boolean updateUser(UsersDto newUser);

    Boolean changePass(UsersDto newUser);

    UsersDto login(UsersDto newUser);

    UsersDto findUserByEmail(UsersDto newUser);
}
