package com.skolsam.firstToTen.easy;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));    // true
        System.out.println(isPalindrome(-121));   // false
        System.out.println(isPalindrome(10));     // false
        System.out.println(isPalindrome(1234321));// true
        System.out.println(isPalindrome(12332321));// true
    }

    public static boolean isPalindrome(int number) {
        if (number < 0 || (number % 10 == 0 && number != 0)) {
            return false;
        }

        int reversedHalf = 0;

        while (number > reversedHalf) {
            final int digit = number % 10;
            reversedHalf = reversedHalf * 10 + digit;
            number /= 10;
        }

        return number == reversedHalf || number == reversedHalf / 10;
    }
}
