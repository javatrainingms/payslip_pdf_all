package com.pdf.generate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateFormatExample {
    public static void main(String[] args) {
        // Create a LocalDate instance
        LocalDate date = LocalDate.now(); // Or any specific LocalDate

        // Define the formatter with the desired pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Format the LocalDate
        String formattedDate = date.format(formatter);

        // Print the formatted date
        System.out.println("Formatted Date: " + formattedDate);
    }
}
