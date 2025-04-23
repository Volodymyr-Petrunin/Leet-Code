package com.skolsam.firstToTen.hard;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        final int[] firstArray = {2};
        final int[] secondArray = {};

        if (firstArray.length > secondArray.length){
            System.out.println(findMedianSortedArrays(secondArray, firstArray));
        } else {
            System.out.println(findMedianSortedArrays(firstArray, secondArray));
        }

    }

    public static double findMedianSortedArrays(int[] firstArray, int[] secondArray) {
        int firstArrayLength = firstArray.length;
        int secondArrayLength = secondArray.length;

        int low = 0;
        int high = firstArrayLength;

        while (low <= high) {
            int partitionFirst = (low + high) / 2;
            int partitionSecond = (firstArrayLength + secondArrayLength + 1) / 2 - partitionFirst;

            int maxLeftFirst = (partitionFirst == 0) ? Integer.MIN_VALUE : firstArray[partitionFirst - 1];
            int minRightFirst = (partitionFirst == firstArrayLength) ? Integer.MAX_VALUE : firstArray[partitionFirst];

            int maxLeftSecond = (partitionSecond == 0) ? Integer.MIN_VALUE : secondArray[partitionSecond - 1];
            int minRightSecond = (partitionSecond == secondArrayLength) ? Integer.MAX_VALUE : secondArray[partitionSecond];

            if (maxLeftFirst <= minRightSecond && maxLeftSecond <= minRightFirst) {
                if((firstArrayLength + secondArrayLength) % 2 == 0) {
                    return (Math.max(maxLeftFirst, maxLeftSecond) + Math.min(minRightFirst, minRightSecond)) / 2.0;
                } else {
                    return Math.max(maxLeftFirst, maxLeftSecond);
                }
            } else if (maxLeftFirst > minRightSecond) {
                high = partitionFirst - 1;
            } else {
                low = partitionFirst + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted or invalid");
    }
}
