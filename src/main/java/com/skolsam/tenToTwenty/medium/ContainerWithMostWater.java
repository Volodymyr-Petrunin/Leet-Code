package com.skolsam.tenToTwenty.medium;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,5,1,4}));
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int begin = 0;
        int end = height.length - 1;
        int maxArea = 0;

        while (begin < end) {
            int width = end - begin;
            int minHeight = Math.min(height[begin], height[end]);
            int currentArea = width * minHeight;

            maxArea = Math.max(maxArea, currentArea);

            if (height[begin] < height[end]) {
                begin++;
            } else {
                end--;
            }
        }

        return maxArea;
    }
}
