package org.pro.optis.backend.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pro.optis.backend.bo.User;
import org.pro.optis.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



@RestController
@Slf4j //logger
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:5500")
public class AuthController {


    private final UserService userService;

    AuthController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/signin")
    public void signin(@RequestBody User user) {
        this.userService.signin(user);
    }

}
