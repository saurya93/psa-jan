package com.Gblogs.controller;

import com.Gblogs.entity.Station;
import com.Gblogs.repository.StationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/station")
public class StationController {

    private StationRepository stationRepository;

    public StationController(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    //http://localhost:8080/api/v1/station/addStation
    @PostMapping("/addStation")
    public ResponseEntity<Station> addStation(@RequestBody Station  station){
        Station save = stationRepository.save(station);
        return new ResponseEntity<>(save, HttpStatus.CREATED);

    }
}
