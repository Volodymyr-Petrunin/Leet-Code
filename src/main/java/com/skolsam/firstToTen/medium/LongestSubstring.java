package com.skolsam.firstToTen.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(final String word) {
        final Map<Character, Integer> map = new HashMap<>();

        int begin = 0;
        int maxLength = 0;

        for (int end = 0; end < word.length(); end++) {
            final char currentChar = word.charAt(end);

            if (map.containsKey(currentChar)) {
                begin = Math.max(map.get(currentChar), begin);
            }

            map.put(currentChar, end + 1);
            maxLength = Math.max(maxLength, end - begin + 1);
        }

        return maxLength;
    }
}
