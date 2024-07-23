package com.Gblogs.controller;

import com.Gblogs.entity.Train;
import com.Gblogs.repository.StationRepository;
import com.Gblogs.repository.TrainRepository;
import com.Gblogs.repository.Train_journeyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/train")
public class TrainController {
    private TrainRepository trainRepository;
    private Train_journeyRepository trainJourneyRepository;
    private StationRepository stationRepository;

    public TrainController(TrainRepository trainRepository, Train_journeyRepository trainJourneyRepository, StationRepository stationRepository) {
        this.trainRepository = trainRepository;
        this.trainJourneyRepository = trainJourneyRepository;
        this.stationRepository = stationRepository;
    }

    //http://localhost:8080/api/v1/train/addTrains
    @PostMapping("/addTrains")
    public ResponseEntity<Train> addTrains(@RequestBody Train train){
        Train save = trainRepository.save(train);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}
