package com.skolsam.firstToTen.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class AddTwoNumbers {

    public static class ListNode {

        private final int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        final ListNode firstList = new ListNode(5, new ListNode(4, new ListNode(7)));
        final ListNode secondList = new ListNode(4, new ListNode(6, new ListNode(2)));

        final ListNode result = findResult(firstList, secondList);
        printResult(firstList, secondList, result);
    }

    private static ListNode findResult(final ListNode firstList, final ListNode secondList) {
        ListNode firstNode = firstList;
        ListNode secondNode = secondList;

        final ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        int carry = 0;

        while (firstNode != null || secondNode != null) {
            int firstNumber = (firstNode != null) ? firstNode.val : 0;
            int secondNumber = (secondNode != null) ? secondNode.val : 0;

            int sum = firstNumber + secondNumber + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (firstNode != null) firstNode = firstNode.next;
            if (secondNode != null) secondNode = secondNode.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    private static void printResult(final ListNode firstList, final ListNode secondList, final ListNode result) {
        final String resultString = new StringJoiner(System.lineSeparator())
                .add("l1 -> " + Arrays.toString(getAllNumbers(firstList)) + ", l2 -> " + Arrays.toString(getAllNumbers(secondList)))
                .add("Result: " + Arrays.toString(getAllNumbers(result)))
                .toString();

        System.out.println(resultString);
    }

    private static int[] getAllNumbers(ListNode head) {
        final List<Integer> numbers = new ArrayList<>();

        while (head != null) {
            numbers.add(head.val);
            head = head.next;
        }

        return numbers.stream().mapToInt(num -> num).toArray();
    }
}
