package org.pro.optis.backend.controller;


import org.pro.optis.backend.bo.*;
import org.pro.optis.backend.bo.request.*;
import org.pro.optis.backend.bo.response.*;
import org.pro.optis.backend.service.OptimaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/3")
    public List<Optima3Response> calculateOptimum3(@RequestBody Optima3Request requests) {
        return optimaService.calculateOptimum3(requests);
    }
    @PostMapping("/4")
    public ResponseEntity<Optima4Response> calculateOptimum4(@RequestBody Optima4Request request) {
        Optima4Response response = optimaService.calculateOptimum4(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/5")
    public ResponseEntity<Optima5Response> calculateOptimum5(@RequestBody Optima5Request request) {
        Optima5Response response = optimaService.calculateOptimum5(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/6")
    public ResponseEntity<Optima6Response> calculateOptimum6(@RequestBody Optima6Request request) {
        Optima6Response response = optimaService.calculateOptimum6(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/7")
    public ResponseEntity<Optima7Response> calculateOptimum7(@RequestBody Optima7Request request) {
        Optima7Response response = optimaService.calculateOptimum7(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/8")
    public ResponseEntity<Optima8Response> calculateOptimum8(@RequestBody Optima8Request request) {
        Optima8Response response = optimaService.calculateOptimum8(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/9")
    public ResponseEntity<Optima9Response> calculateOptimum9(@RequestBody Optima9Request request) {
        Optima9Response response = optimaService.calculateOptimum9(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/X")
    public ResponseEntity<OptimaXResponse> calculateOptimumX(@RequestBody OptimaXRequest request) {
        OptimaXResponse response = optimaService.calculateOptimumX(request);
        return ResponseEntity.ok(response);
    }

}
