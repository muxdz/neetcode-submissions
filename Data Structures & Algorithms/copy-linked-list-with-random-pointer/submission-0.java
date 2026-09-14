/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> nodeMap = new HashMap<>();
        Node head2 = head;
        Node dummy = null;

        while (head != null) {
            dummy = new Node(head.val);
            nodeMap.put(head, dummy);

            head = head.next;
        }

        head = head2;

        while (head != null) {
            dummy = nodeMap.get(head);
            dummy.next = nodeMap.get(head.next);
            dummy.random = nodeMap.get(head.random);

            head = head.next;
        }

        return nodeMap.get(head2);
    }
}
