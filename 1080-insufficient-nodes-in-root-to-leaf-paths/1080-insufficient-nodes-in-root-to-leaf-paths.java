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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root == null) return null;
        boolean ans = solve(root,limit,0);
        if(ans == false) return null;
        else return root;
    }
    public boolean solve(TreeNode root, int limit, int sum){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(sum + root.val < limit) return false;
            else return true;
        }
        boolean left = solve(root.left,limit,sum + root.val);
        boolean right = solve(root.right,limit, sum + root.val);
        if(left == false && right == false){
            return false;
        }
        else if(right == false){
            root.right = null;
        }
        else if(left == false){
            root.left = null;
        }
        return true;
    }
}