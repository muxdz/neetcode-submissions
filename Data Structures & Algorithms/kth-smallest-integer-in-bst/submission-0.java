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
    int count = 0;
    int val;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return val;
    }

    public void dfs(TreeNode node, int k) {
        if (node == null) return;

        dfs(node.left, k);
        count++;

        if (count == k) {
            val = node.val;
            return;
        }

        dfs(node.right, k);
    }
}
