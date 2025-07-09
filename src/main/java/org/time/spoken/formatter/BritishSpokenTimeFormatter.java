package org.time.spoken.formatter;




import org.time.spoken.util.NumberWordsMapper;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BritishSpokenTimeFormatter implements TimeFormatter {

    @Override
    public String format(String time) {
        LocalTime localTime = parseTime(time);

        int hour = localTime.getHour();
        int minute = localTime.getMinute();

        if (hour == 0 && minute == 0) return "midnight";
        if (hour == 12 && minute == 0) return "noon";

        int spokenHour = hour % 12 == 0 ? 12 : hour % 12;
        int nextHour = (spokenHour % 12) + 1;

        if (minute == 0) return formatOClock(spokenHour);

        // Named intervals for 'past' expressions
        if (minute == 5 || minute == 10 || minute == 15 || minute == 20 || minute == 25 || minute == 30) {
            return NumberWordsMapper.get(minute) + " past " + NumberWordsMapper.get(spokenHour);
        }

        // Named intervals for 'to' expressions
        if (minute == 35 || minute == 40 || minute == 45 || minute == 50 || minute == 55) {
            return NumberWordsMapper.get(60 - minute) + " to " + NumberWordsMapper.get(nextHour);
        }

        // Fallback to hour minute (e.g., "six thirty-two")
        return NumberWordsMapper.get(spokenHour) + " " + NumberWordsMapper.get(minute);
    }

    private String formatOClock(int hour) {
        return NumberWordsMapper.get(hour) + " o'clock";
    }

    private LocalTime parseTime(String input) {
        try {
            return LocalTime.parse(input.trim(), DateTimeFormatter.ofPattern("H:mm"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid time format. Use HH:mm.");
        }
    }
}