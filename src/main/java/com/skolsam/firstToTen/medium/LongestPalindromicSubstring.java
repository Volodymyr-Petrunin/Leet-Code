package com.skolsam.firstToTen.medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String palindrom = "aaaaa";
        System.out.println("Full palindrome: " + palindrom + ", longest part: " + longestPalindrome(palindrom));
    }

    public static String longestPalindrome(final String palindrome) {
        if (palindrome == null || palindrome.isEmpty()) {
            return "";
        } else if (palindrome.chars().distinct().count() == 1) {
            return palindrome;
        }

        String longest = "";

        for (int center = 0; center < palindrome.length(); center++) {
            final String oddPalindrome = expandFromCenter(palindrome, center, center);
            final String evenPalindrome = expandFromCenter(palindrome, center, center + 1);

            final String currentLongest = oddPalindrome.length() > evenPalindrome.length() ? oddPalindrome : evenPalindrome;

            if (currentLongest.length() > longest.length()) {
                longest = currentLongest;
            }

            if (longest.length() >= palindrome.length() - center) {
                break;
            }
        }

        return longest;
    }


    private static String expandFromCenter(String palindrome, int left, int right) {
        while (left >= 0 && right < palindrome.length() && palindrome.charAt(left) == palindrome.charAt(right)) {
            left--;
            right++;
        }

        return palindrome.substring(left + 1, right);
    }

}
