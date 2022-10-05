package com.assesment.speakingclock.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SpeakingClockService {

    public String getTimeInStr(String userInput) {
        String timeInWord = "Invalid Input";
        try {
            Date date;
            DateFormat dateFormat = new SimpleDateFormat("kk:mm");
            if (StringUtils.hasText(userInput)) {
                date = dateFormat.parse(userInput);
            } else {
                date = new Date();
            }

            String timeIn24Hours = dateFormat.format(date);
            int h = Integer.parseInt(timeIn24Hours.substring(0, 2));
            int m = Integer.parseInt(timeIn24Hours.substring(3));
            if (h == 24 && m == 0) {
                timeInWord = "It's Midnight";
            } else if (h == 12 && m == 0) {
                timeInWord = "It's Midday";
            } else {
                timeInWord = "It's " + getNumberToWord(h) + " " + getNumberToWord(m);
            }
            return timeInWord;
        } catch (Exception ignored) {
        }
        return timeInWord;
    }

    public String getNumberToWord(int num) {
        if (num >= 60) {
            return "";
        } else {
            int n1 = num, n2 = num;
            int b = n1 % 10, a = n2 / 10;
            String wordValue = "";
            String[] singleDigits = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
            String[] twoDigits = new String[]{"", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
            String[] tensMultiple = new String[]{"", "", "twenty", "thirty", "forty", "fifty"};
            if (a == 1) {
                wordValue = twoDigits[b + 1];
            } else if (b == 0) {
                wordValue = tensMultiple[a];
            } else {
                wordValue = tensMultiple[a] + (a != 0 ? " " : "") + singleDigits[b];
            }
            return wordValue;
        }
    }
}
