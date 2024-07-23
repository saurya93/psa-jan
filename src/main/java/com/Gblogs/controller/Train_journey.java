package com.Gblogs.controller;

import com.Gblogs.entity.Station;
import com.Gblogs.entity.Train;
import com.Gblogs.repository.StationRepository;
import com.Gblogs.repository.TrainRepository;
import com.Gblogs.repository.Train_journeyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/journey")
public class Train_journey {
    private TrainRepository trainRepository;
    private Train_journeyRepository trainJourneyRepository;
    private StationRepository stationRepository;

    public Train_journey(TrainRepository trainRepository, Train_journeyRepository trainJourneyRepository, StationRepository stationRepository) {
        this.trainRepository = trainRepository;
        this.trainJourneyRepository = trainJourneyRepository;
        this.stationRepository = stationRepository;
    }

    @PostMapping("/saveJourney")
    public ResponseEntity<Train_journey> saveJourney(
            @RequestParam long trainId,
            @RequestParam long stationId,
            @RequestBody Train_journey trainJourney) {


        Train train = trainRepository.findById(trainId).get();
        Station station = stationRepository.findById(stationId).get();
        System.out.println("hey there"+stationId);
        System.out.println("hey there"+trainId);
                return null;
    }
}
//    @PostMapping
//    public Train_journey journey(@RequestParam long trainID,
//                                     @RequestParam long stationID,
//                                     @RequestBody Train_journey trainJourney){
//        Train train = trainRepository.findById(trainID).get();
//       if (trainID){
//
//       }
//        Station station = stationRepository.findById(stationID).get();
//
//    }
//}
