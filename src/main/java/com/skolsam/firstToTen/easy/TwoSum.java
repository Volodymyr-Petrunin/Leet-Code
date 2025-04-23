package com.skolsam.firstToTen.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        final int[] numbers = {3, 2, 4, 9, 5};
        final int target = 13;
        System.out.println("nums = " + Arrays.toString(numbers) + ", target = " + target);
        System.out.println(Arrays.toString(twoSum(numbers, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            final int complement = target - nums[index];
            if (map.containsKey(complement)) {
                return new int[] {
                        map.get(complement), index
                };
            }
            map.put(nums[index], index);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
