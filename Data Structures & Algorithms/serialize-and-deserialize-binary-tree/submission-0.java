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

public class Codec {
    int index = 0;
    String[] values;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "N";
        String val = Integer.toString(root.val);

        return val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        values = data.split(",");

        return create();
    }

    public TreeNode create() {
        String val = values[index];
        index++;

        if (val.equals("N")) return null;

        TreeNode node = new TreeNode(Integer.valueOf(val));

        node.left = create();
        node.right = create();

        return node;
    }
}
