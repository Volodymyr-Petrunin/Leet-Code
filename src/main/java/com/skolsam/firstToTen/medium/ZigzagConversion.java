package com.skolsam.firstToTen.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ZigzagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println("PAHNAPLSIIGYIR");
    }

    public static String convert(final String text, int numRows) {
        if (numRows == 1 || text.length() <= numRows) {
            return text;
        }

        final StringBuilder[] rows = IntStream.range(0, numRows)
                .mapToObj(StringBuilder::new)
                .toArray(StringBuilder[]::new);

        int currentRow = 0;
        boolean goingDown = false;

        for (char character : text.toCharArray()) {
            rows[currentRow].append(character);

            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        // Combine all lines from the rader array into one final line
        // Use collect with:
        // - new StringBuilder
        // - append method for each element
        // - and the final union

        return Arrays.stream(rows)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
