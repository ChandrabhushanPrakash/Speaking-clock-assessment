package com.assesment.speakingclock.controller;

import com.assesment.speakingclock.services.SpeakingClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/speaking-clock")
public class SpeakingClockController {

    @Autowired
    private SpeakingClockService speakingClockService;

    @GetMapping("/time")
    public ResponseEntity<String> getTimeInStr() {
        String response = speakingClockService.getTimeInStr(null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/time/{userInput}")
    public ResponseEntity<String> getTimeInStrForUserInput(@PathVariable String userInput) {
        String response = speakingClockService.getTimeInStr(userInput);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
