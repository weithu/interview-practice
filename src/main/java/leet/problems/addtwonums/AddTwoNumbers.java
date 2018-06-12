package leet.problems.addtwonums;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddTwoNumbers {
    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     *
     */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = null;
        ListNode head = null;
        boolean carry = false;
        while(l1 !=null || l2 !=null) {
            int digit = 0;
            if(l1 == null){
                digit = l2.val;
                l2 = l2.next;
            }
            else if(l2 == null){
                digit = l1.val;
                l1 = l1.next;
            }else {
                digit = l1.val + l2.val;

                l1 = l1.next;
                l2 = l2.next;
            }
            if(carry){
                digit += 1;
                carry = false;
            }

            if (digit >= 10) {
                digit = digit % 10;
                carry = true;
            }
            if(sum==null){

                sum = new ListNode(digit);
                head = sum;
            } else {
                sum.next = new ListNode(digit);
                sum = sum.next;
            }
        }
        if(carry){
            sum.next = new ListNode(1);
        }


        return head;
    }

    @Test
    public void testBaseCase(){
        /**
         * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
         * Output: 7 -> 0 -> 8
         * Explanation: 342 + 465 = 807.
         **/
        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l2.next = l4;
        l4.next = l3;


        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l5.next = l6;
        l6.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode a = addTwoNumbers.addTwoNumbers(l2, l5);
        assertEquals(a.val, 7);
        assertEquals(a.next.val, 0);
        assertEquals(a.next.next.val, 8);
    }

    @Test
    public void testUnevenDigits(){
        /**
         * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
         * Output: 7 -> 0 -> 8
         * Explanation: 342 + 465 = 807.
         **/
        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);

        l2.next = l4;



        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l5.next = l6;
        l6.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode a = addTwoNumbers.addTwoNumbers(l2, l5);
        assertEquals(a.val, 7);
        assertEquals(a.next.val, 0);
        assertEquals(a.next.next.val, 5);
    }



    @Test
    public void testFinalDigitCarry(){

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode a = addTwoNumbers.addTwoNumbers(l1, l2);
        assertEquals(a.val, 0);
        assertEquals(a.next.val, 1);
    }
}
