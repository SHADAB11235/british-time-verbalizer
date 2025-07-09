package org.time.spoken;
import org.junit.jupiter.api.Test;
import org.time.spoken.formatter.BritishSpokenTimeFormatter;
import org.time.spoken.formatter.TimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class BritishSpokenTimeFormatterTest {

    private final TimeFormatter formatter = new BritishSpokenTimeFormatter();

    @Test
    void testExactTimes() {
        assertEquals("midnight", formatter.format("00:00"));
        assertEquals("noon", formatter.format("12:00"));
        assertEquals("one o'clock", formatter.format("01:00"));
    }

    @Test
    void testPastTimes() {
        assertEquals("quarter past four", formatter.format("04:15"));
        assertEquals("five past two", formatter.format("02:05"));
        assertEquals("twenty-five past six", formatter.format("06:25"));
    }

    @Test
    void testToTimes() {
        assertEquals("twenty-five to eight", formatter.format("07:35"));
        assertEquals("quarter to ten", formatter.format("09:45"));
        assertEquals("five to twelve", formatter.format("11:55"));
    }

    @Test
    void testHalfPast() {
        assertEquals("half past seven", formatter.format("07:30"));
        assertEquals("half past ten", formatter.format("10:30"));
    }

    @Test
    void testExactMinutes() {
        assertEquals("six thirty-two", formatter.format("06:32"));
    }

    @Test
    void testInvalidTime() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> formatter.format("99:99"));
        assertEquals("Invalid time format. Use HH:mm.", ex.getMessage());
    }
}
