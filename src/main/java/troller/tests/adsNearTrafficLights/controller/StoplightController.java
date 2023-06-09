package troller.tests.adsNearTrafficLights.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import troller.tests.adsNearTrafficLights.dto.StoplightResponse;
import troller.tests.adsNearTrafficLights.service.StoplightService;

@RestController
@RequestMapping("/stoplight")
public class StoplightController {

    @Autowired
    private StoplightService stoplightService;

    @PostMapping("/create")
    public ResponseEntity<?> createStoplight(@RequestBody Map<String, Object> stoplightData) {
        StoplightResponse stoplight = stoplightService.createStoplight(stoplightData);
        return ResponseEntity.ok(stoplight);
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStopLights() {
        List<StoplightResponse> allStopLights;
        allStopLights = stoplightService.getAllStoplights();
        return ResponseEntity.ok(allStopLights);
}
}

