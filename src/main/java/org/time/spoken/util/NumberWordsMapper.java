package org.time.spoken.util;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class NumberWordsMapper {
    private static final Map<Integer, String> numberWords = new HashMap<>();

    static {
        String[] words = {
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen",
                "nineteen", "twenty", "twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five",
                "twenty-six", "twenty-seven", "twenty-eight", "twenty-nine", "half"
        };
        IntStream.rangeClosed(0, 30).forEach(i -> numberWords.put(i, words[i]));
        numberWords.put(15, "quarter");
        numberWords.put(30, "half");
    }

    public static String get(int number) {
        return numberWords.containsKey(number) ? numberWords.get(number) : convertToWords(number);
    }

    private static String convertToWords(int number) {
        if (number < 31) return String.valueOf(number);

        int tens = number / 10;
        int ones = number % 10;

        String[] tensWords = {"", "", "twenty", "thirty", "forty", "fifty"};
        String[] onesWords = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        if (tens >= tensWords.length) return String.valueOf(number); // fallback for safety

        return ones == 0 ? tensWords[tens] : tensWords[tens] + "-" + onesWords[ones];
    }
}
