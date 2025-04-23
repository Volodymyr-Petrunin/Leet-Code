package com.skolsam.firstToTen.hard;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
    }

    public static boolean isMatch(final String input, final String pattern) {
        return input.matches(pattern);
    }
}
