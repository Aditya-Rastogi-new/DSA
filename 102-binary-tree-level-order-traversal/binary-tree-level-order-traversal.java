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
 class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
 }
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        if (root == null)
            return ans;
        levelOrderLineWise(root, ans, arr);
        return ans;
    }
    public void levelOrderLineWise(TreeNode root,List<List<Integer>> ans,List<Integer> arr){
        Queue<Pair> q = new LinkedList<>();
        int currLevel = 0;
        q.add(new Pair(root,0));
        while(q.size() > 0){
            Pair p = q.remove();
            TreeNode node = p.node;
            int level = p.level;
            if(level != currLevel){
                currLevel++;
                ans.add(arr);
                arr = new ArrayList<>();
            }
            arr.add(node.val);
            if(node.left != null){
                q.add(new Pair(node.left, level + 1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, level + 1));
            }
        }
        ans.add(arr);
    }
}