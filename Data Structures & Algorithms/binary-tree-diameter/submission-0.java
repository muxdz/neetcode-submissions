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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int lHeight = binaryHeight(root.left);
        int rHeight = binaryHeight(root.right);
        diameter = Math.max(diameter, lHeight+rHeight);

        return diameter;
    }

    public int binaryHeight(TreeNode root) {
        if (root == null) return 0;

        int lCount = binaryHeight(root.left);
        int rCount = binaryHeight(root.right);
        diameter = Math.max(diameter, lCount+rCount);

        return Math.max(lCount, rCount)+1;
    }
}
