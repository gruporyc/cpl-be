package co.cpl.service.impl;

import co.cpl.api.generated.model.SimpleResponse;
import co.cpl.api.generated.model.User;
import co.cpl.dto.UsersDto;
import co.cpl.service.APIManager;
import co.cpl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    APIManager apiManager;



    @Override
    public List<UsersDto> getUsers(Long offset, Long limit) {

        return apiManager.getUsers(offset, limit);
    }

    @Override
    public UsersDto getUserById(String userId) {

        //UsersDto userById = apiManager.getUserById(userId);
        return apiManager.getUserById(userId);
    }

    @Override
    public SimpleResponse deleteUser(String userId) {

        return  apiManager.deleteUser(userId);
    }

    @Override
    public Integer createUser(UsersDto newUser) {

        return apiManager.createUser(newUser);
    }

    @Override
    public Boolean updateUser(UsersDto newUser) {

        return apiManager.updateUser(newUser);
    }

    @Override
    public Boolean changePass(UsersDto newUser) {

        return apiManager.changePass(newUser);
    }

    @Override
    public UsersDto login(UsersDto newUser) {

        return apiManager.login(newUser);
    }

    @Override
    public UsersDto findUserByEmail(UsersDto newUser) {
        return apiManager.findUserByEmail(newUser);
    }
}
