package com.skolsam.firstToTen.medium;

public class Atoi {

    public static void main(String[] args) {
        System.out.println(myAtoi("+-12"));
        System.out.println(myAtoi("words and 987"));   // 0
        System.out.println(myAtoi("   -42"));          // -42
        System.out.println(myAtoi("4193 with words")); // 4193
        System.out.println(myAtoi(".1"));              // 0
    }

    public static int myAtoi(final String string) {
        if (!isValidForParsing(string)) return 0;

        final StringBuilder stringBuilder = new StringBuilder();
        final char[] wordChars = string.toCharArray();

        for (final char currentChar : wordChars) {
            if (Character.isDigit(currentChar) || currentChar == '-' && stringBuilder.isEmpty()) {
                stringBuilder.append(currentChar);
            } else if (!stringBuilder.isEmpty() && !Character.isDigit(currentChar)) {
                break;
            }
        }

        if (stringBuilder.isEmpty()) {
            return 0;
        }

        try {
            return Integer.parseInt(stringBuilder.toString());
        } catch (NumberFormatException e) {
            if (stringBuilder.toString().startsWith("-")) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }


    private static boolean isValidForParsing(final String input) {
        final String trimmed = input.trim();
        if (trimmed.isEmpty()) return false;

        char first = trimmed.charAt(0);

        if (Character.isDigit(first)) {
            return true;
        }

        if ((first == '+' || first == '-') && trimmed.length() > 1) {
            return Character.isDigit(trimmed.charAt(1));
        }

        return false;
    }

}
