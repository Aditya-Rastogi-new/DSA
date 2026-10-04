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
    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root,0);
        return root;
    }
    public int reverseInorder(TreeNode root, int sum){
        if(root == null) return sum;
        sum = reverseInorder(root.right, sum);
        sum += root.val;
        root.val  = sum;
        return reverseInorder(root.left, sum);
    }
}