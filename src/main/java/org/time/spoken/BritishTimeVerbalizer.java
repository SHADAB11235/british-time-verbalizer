package org.time.spoken;

import org.time.spoken.formatter.BritishSpokenTimeFormatter;
import org.time.spoken.formatter.TimeFormatter;

import java.util.Scanner;

public class BritishTimeVerbalizer
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time in HH:mm format: ");
        String input = scanner.nextLine();

        TimeFormatter formatter = new BritishSpokenTimeFormatter();
        try {
            String spokenTime = formatter.format(input);
            System.out.println("Spoken Time: " + spokenTime);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
