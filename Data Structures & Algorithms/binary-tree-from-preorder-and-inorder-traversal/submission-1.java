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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i=0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return build(
            preorder,
            0,
            preorder.length-1,
            0,
            inorder.length-1,
            inMap
        );
    }

    private TreeNode build(
        int[] preorder,
        int preStart,
        int preEnd,
        int inStart,
        int inEnd,
        Map<Integer, Integer> inMap
    ) {
        if (preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inMap.get(rootVal);

        int leftSize = rootIndex-inStart;

        root.left = build(
            preorder,
            preStart+1,
            preStart+leftSize,
            inStart,
            rootIndex-1,
            inMap
        );

        root.right = build(
            preorder,
            preStart+leftSize+1,
            preEnd,
            rootIndex+1,
            inEnd,
            inMap
        );

        return root;
    }
}
