/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = groupPrev;
            for (int i=0; i<k; i++) {
                kth = kth.next;
                if (kth == null) {
                    return dummy.next;
                }
            }

            ListNode next = kth.next;
            ListNode start = groupPrev.next;

            ListNode prev = next;
            ListNode curr = start;
            while (curr != next) {
                ListNode temp = curr.next;
                curr.next = prev;

                prev = curr;
                curr = temp;
            }

            groupPrev.next = prev;

            groupPrev = start;
        }
    }
}
