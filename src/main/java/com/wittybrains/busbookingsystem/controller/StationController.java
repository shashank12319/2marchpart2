
package com.wittybrains.busbookingsystem.controller;


import com.wittybrains.busbookingsystem.dto.StationDTO;
import com.wittybrains.busbookingsystem.model.Station;
import com.wittybrains.busbookingsystem.repository.StationRepository;
import com.wittybrains.busbookingsystem.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stations")
public class StationController {

    @Autowired
	private StationRepository stationRepository;
    @PostMapping
    public ResponseEntity<String> createStation(@RequestBody StationDTO stationDTO) {
    	// Create a new Station object
	    Station station = new Station(stationDTO.getName(), stationDTO.getStationCode());

	    // Save the Station to the database
	    stationRepository.save(station);
	    return new ResponseEntity<>("Successfully created station with ID: " + station.getId(), HttpStatus.CREATED);
    }

}