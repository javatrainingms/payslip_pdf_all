package com.pdf.generate.soc;
public class NumberToWordsIndian {
    private static final String[] BELOW_TWENTY = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] TENS = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] UNITS = {
        "", "Thousand", "Lakh", "Crore"
    };

    public static String numberToWords(int num) {
        if (num == 0) return "zero";

        String words = "";

        // Process crores
        if (num / 10000000 > 0) {
            words += helper(num / 10000000) + "Crore ";
            num %= 10000000;
        }

        // Process lakhs
        if (num / 100000 > 0) {
            words += helper(num / 100000) + "Lakh ";
            num %= 100000;
        }

        // Process thousands
        if (num / 1000 > 0) {
            words += helper(num / 1000) + "Thousand ";
            num %= 1000;
        }

        // Process the remaining number below 1000
        if (num > 0) {
            words += helper(num);
        }

        return words.trim();
    }

    // Helper method to process numbers below 1000
    private static String helper(int num) {
        if (num == 0) return "";
        if (num < 20) return BELOW_TWENTY[num] + " ";
        if (num < 100) return TENS[num / 10] + " " + BELOW_TWENTY[num % 10] + " ";
        return BELOW_TWENTY[num / 100] + " Hundred " + helper(num % 100);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(numberToWords(123));          // Output: "one hundred twenty three"
        System.out.println(numberToWords(1234));         // Output: "one thousand two hundred thirty four"
        System.out.println(numberToWords(123456));       // Output: "one lakh twenty three thousand four hundred fifty six"
        System.out.println(numberToWords(12345678));     // Output: "one crore twenty three lakh forty five thousand six hundred seventy eight"
        System.out.println(numberToWords(0));            // Output: "zero"
    }
}
