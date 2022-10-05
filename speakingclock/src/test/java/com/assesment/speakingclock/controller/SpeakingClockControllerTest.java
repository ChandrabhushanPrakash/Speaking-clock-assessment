package com.assesment.speakingclock.controller;

import com.assesment.speakingclock.services.SpeakingClockService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith({MockitoExtension.class})
@SpringBootTest(classes = SpeakingClockController.class)
class SpeakingClockControllerTest {

    @Autowired
    private SpeakingClockController speakingClockController;

    @MockBean
    private SpeakingClockService speakingClockService;

    @DisplayName("JUnit test for controller working flow when user input is provided")
    @Test
    public void testSpeakingClockController() {
        ResponseEntity<String> response = new ResponseEntity<>("", HttpStatus.OK);
        Mockito.doReturn(response.getBody()).when(speakingClockService).getTimeInStr(Mockito.anyString());
        response = speakingClockController.getTimeInStrForUserInput(Mockito.anyString());
        Mockito.verify(speakingClockService, Mockito.atLeastOnce()).getTimeInStr(Mockito.anyString());
    }

    @DisplayName("JUnit test for controller working flow when no user input is provided")
    @Test
    public void testSpeakingClockControllerWithNoUserInput() {
        ResponseEntity<String> response = new ResponseEntity<>("", HttpStatus.OK);
        Mockito.doReturn(response.getBody()).when(speakingClockService).getTimeInStr(null);
        response = speakingClockController.getTimeInStrForUserInput(null);
        Mockito.verify(speakingClockService, Mockito.atLeastOnce()).getTimeInStr(null);
    }

}
