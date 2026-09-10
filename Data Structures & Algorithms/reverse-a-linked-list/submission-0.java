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
    public ListNode reverseList(ListNode head) {
        ListNode current = null;
        ListNode traverse = null;

        while (head != null) {
            traverse = new ListNode(head.val, current);

            current = traverse;

            head = head.next;
        }

        return traverse;
    }
}
