package leet.problems.mergesortedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MergeSortedLists {
    /**
     * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
     *
     * Example:
     *
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     *
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode head = null;
        ListNode toReturn = null;

        while(n1 != null){
            if(toReturn == null){
                if(n1.val < n2.val){
                    toReturn = n1;
                    head = toReturn;
                    n1 = n1.next;
                } else {
                    toReturn = n2;
                    head = toReturn;
                    n2 = n2.next;
                }
            }
            else {
                if(n2 == null){//out of the loop if one list is already done
                    toReturn.next = n1;
                    return head;
                }

                if(n1.val < n2.val){
                    toReturn.next = n1;
                    toReturn = n1;
                    n1 = n1.next;

                } else {
                    toReturn.next = n2;
                    toReturn = n2;
                    n2 = n2.next;
                }
            }
        }
        if(n2 != null){
            toReturn.next = n2;
        }

        return head;
    }

    @Test
    public void baseCaseTest(){
        MergeSortedLists msl = new MergeSortedLists();
        /**
         *
         * Input: 1->2->4, 1->3->4
         * Output: 1->1->2->3->4->4
         */

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next=l5;
        l5.next=l6;

        ListNode r = msl.mergeTwoLists(l1, l4);
        assertEquals(r.val, 1);
        r = r.next;

        assertEquals(r.val, 1);
        r = r.next;
        assertEquals(r.val, 2);
        r = r.next;
        assertEquals(r.val, 3);
        r = r.next;
        assertEquals(r.val, 4);
        r = r.next;
        assertEquals(r.val, 4);
        r = r.next;
        assertNull(r);

    }
}
