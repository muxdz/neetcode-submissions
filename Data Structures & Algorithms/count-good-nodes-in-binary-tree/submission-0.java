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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int goodCount = 1;

        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> maxVal = new ArrayDeque<>();
        queue.add(root);
        maxVal.add(root.val);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i=0; i<levelSize; i++) {
                TreeNode node = queue.remove();
                int val = maxVal.remove();

                if (node.left != null) {
                    if (node.left.val >= val) {
                        goodCount++;
                    }
                    queue.add(node.left);
                    maxVal.add(Math.max(val, node.left.val));
                }

                if (node.right != null) {
                    if (node.right.val >= val) {
                        goodCount++;
                    }
                    queue.add(node.right);
                    maxVal.add(Math.max(val, node.right.val));
                }
            }
        }

        return goodCount;
    }
}
