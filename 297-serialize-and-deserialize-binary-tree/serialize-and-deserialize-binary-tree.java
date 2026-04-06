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

    // Encodes a tree to a single string.
    StringBuilder s=new StringBuilder();
    HashMap<Integer,TreeNode>map=new HashMap<>();
    public String serialize(TreeNode root) {
         if(root == null) {
        s.append("n,");
        return s.toString();
    }
    s.append(root.val).append(',');
    map.put(root.val,root);
    serialize(root.left);
    serialize(root.right);
    return s.toString();
    }

    // Decodes your encoded data to tree.
    int index=0;
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return build(arr);
    }
    TreeNode build(String[] arr) {

        if(arr[index].equals("n")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[index]));
        index++;

        node.left = build(arr);
        node.right = build(arr);

        return node;
    }
}
