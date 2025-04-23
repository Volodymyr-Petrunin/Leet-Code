package com.skolsam.firstToTen.medium;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-231));
    }

    public static int reverse(int number) {
        try {
            final String reversed = new StringBuilder(String.valueOf(Math.abs(number))).reverse().toString();
            final int result = Integer.parseInt(reversed);
            return number < 0 ? -result : result;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
