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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pass1 = head;

        int count = 0;
        while (pass1 != null) {
            count++;
            pass1 = pass1.next;
        }

        int removal = count-n;
        
        if (removal == 0) {
            return head.next;
        }

        ListNode current = head;
        ListNode prev = null;
        
        count = 0;
        while (current != null) {
            ListNode next = current.next;

            if (removal == count) {
                prev.next = next;
                break;
            }

            prev = current;
            current = next;
            count++;
        }


        return head;
    }
}
