/******************************************************************
 *
 * This code is for the Complaints service project.
 *
 *
 * © 2018, Complaints Management All rights reserved.
 *
 *
 ******************************************************************/

package co.cpl.web.controller;

import co.cpl.api.generated.ConsoleController;
import co.cpl.api.generated.HelloController;
import co.cpl.api.generated.IncidenceController;
import co.cpl.api.generated.UserController;
import co.cpl.api.generated.model.SimpleResponse;
import co.cpl.api.generated.model.User;
import co.cpl.dto.IncidenceDto;
import co.cpl.dto.UsersDto;
import co.cpl.enums.ResponseKeyName;
import co.cpl.enums.Status;
import co.cpl.service.HelloService;
import co.cpl.service.IncidenceService;
import co.cpl.service.UserService;
import co.cpl.utilities.CheckCatalogs;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static co.cpl.utilities.Constants.RAML_URL;

/**
 * Main API controller that manage all endpoints functionalities
 *
 * @author jmunoz
 * @since 25/09/2018
 * @version 1.0
 */
@Component
public class APIController extends BaseRestController
        implements HelloController, ConsoleController, UserController, IncidenceController {

    private HelloService helloService;
    private UserService userService;
    private IncidenceService incidenceService;


    public APIController(HelloService helloService, UserService userService, IncidenceService incidenceService) {
        this.helloService = helloService;
        this.userService = userService;
        this.incidenceService = incidenceService;
    }

    @Override
    public ResponseEntity<?> getObject() {
        String path = this.getClass().getClassLoader().getResource(RAML_URL).getPath();
        try {
            return new ResponseEntity<>(Files.readAllBytes(Paths.get(path)), HttpStatus.OK);
        } catch (IOException e) {
            throw new HttpClientErrorException(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @Override
    public ResponseEntity<List<UsersDto>> getUsers(Long offset, Long limit) {
        return new ResponseEntity<>(userService.getUsers(offset, limit), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> createUser(@Valid UsersDto user) {
        //CheckCatalogs.checkStatus(user.getStatus());
        return new ResponseEntity<Object>(userService.createUser(user), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateUser(@Valid UsersDto user) {
        if (!ArrayUtils.contains(Status.values(), user.getStatus()))
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> changePass(@Valid UsersDto user) {
        //CheckCatalogs.checkStatus(user.getStatus());
        return new ResponseEntity<Object>(userService.changePass(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UsersDto> login(@Valid UsersDto user) {
        //CheckCatalogs.checkStatus(user.getStatus());
        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UsersDto> findUserByEmail(@Valid UsersDto user) {
        //CheckCatalogs.checkStatus(user.getStatus());
        return new ResponseEntity<>(userService.findUserByEmail(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UsersDto> getUserByUserId(String userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteUserByUserId(String userId) {
        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getString() {
        return null;
    }

    // INCIDENCE
    @Override
    public ResponseEntity<List<IncidenceDto>> getIncidences(Long offset, Long limit) {
        return new ResponseEntity<>(incidenceService.getIncidences(offset.intValue(), limit.intValue()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> createIncidence(@Valid IncidenceDto user) {
        return new ResponseEntity<Object>(incidenceService.createIncidence(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> updateIncidence(@Valid IncidenceDto user) {
        if (!ArrayUtils.contains(Status.values(), user.getStatus()))
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(incidenceService.updateIncidence(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<IncidenceDto> findIncidenceById(String userId) {
        return new ResponseEntity<>(incidenceService.findIncidenceById(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<IncidenceDto>> findIncidenceByIdUser(String userId) {
        System.out.println("************************************************************ INIT");
        return new ResponseEntity<>(incidenceService.findIncidenceByIdUser(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteIncidence(String userId) {
        return null;
    }
}
