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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();

        for (ListNode list: lists) {
            ListNode current = dummy;
            ListNode l1 = dummy.next;

            while (l1 != null && list != null) {
                if (l1.val <= list.val) {
                    current.next = l1;
                    current = current.next;
                    l1 = l1.next;
                } else {
                    current.next = list;
                    current = current.next;
                    list = list.next;
                }        
            }

            while (l1 != null) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            }

            while (list != null) {
                current.next = list;
                current = current.next;
                list = list.next;
            }
        }

        return dummy.next;
    }
}
