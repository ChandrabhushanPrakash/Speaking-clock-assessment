package com.assesment.speakingclock.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = SpeakingClockService.class)
public class SpeakingClockServiceTest {

    @Autowired
    private SpeakingClockService speakingClockService;

    @DisplayName("JUnit test for getting time when no input is given")
    @Test
    public void getTimeInStrWhenUserInputNotProvided(){
        String userInput = null;
        String response = speakingClockService.getTimeInStr(userInput);
        Assertions.assertNotNull(response);
    }

    @DisplayName("JUnit test for getting time when given time is 12:00")
    @Test
    public void getTimeInStrWhenMidday(){
        String userInput = "12:00";
        String expected = "It's Midday";
        String response = speakingClockService.getTimeInStr(userInput);
        Assertions.assertEquals(expected, response);
    }

    @DisplayName("JUnit test for getting time when given time is 00:00")
    @Test
    public void getTimeInStrWhenMidnight(){
        String userInput = "00:00";
        String expected = "It's Midnight";
        String response = speakingClockService.getTimeInStr(userInput);
        Assertions.assertEquals(expected, response);
    }
}
