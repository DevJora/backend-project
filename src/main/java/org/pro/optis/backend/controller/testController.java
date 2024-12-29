package org.pro.optis.backend.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/test")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5500")
public class testController {
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/url")
    public void testUrl(){
        System.out.println("Test réussi");
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/test")
    public void createAvis() {
    }




}
