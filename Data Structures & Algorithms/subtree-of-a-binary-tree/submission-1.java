/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        return sameTree(root, subRoot)
            || isSubtree(root.left, subRoot) 
            || isSubtree(root.right, subRoot);
    }

    public boolean sameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 != null ^ node2 != null) return false;
        if (node1.val != node2.val) return false;

        return true
            && sameTree(node1.left, node2.left)
            && sameTree(node1.right, node2.right);
    }
}
