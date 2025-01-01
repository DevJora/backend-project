package org.pro.optis.backend.controller;


import org.pro.optis.backend.bo.Optima1Request;
import org.pro.optis.backend.bo.Optima1Response;
import org.pro.optis.backend.bo.Optima2Request;
import org.pro.optis.backend.bo.Optima2Response;
import org.pro.optis.backend.service.OptimaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/optima")
@CrossOrigin(origins = "http://localhost:4200")
public class OptimaController {
    private final OptimaService optimaService;

    public OptimaController(OptimaService optimaService) {
        this.optimaService = optimaService;
    }

    @PostMapping("/1")
    public ResponseEntity<Optima1Response> calculateOptima1(@RequestBody Optima1Request request) {
        Optima1Response response = optimaService.calculateOptimum1(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/2")
    public Optima2Response calculateOptima2(@RequestBody Optima2Request request) {
        return optimaService.calculateOptimum2(request);
    }
}
