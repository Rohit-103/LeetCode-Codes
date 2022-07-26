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
    public class pair{
        TreeNode node;
        int sum;
        pair(TreeNode node, int sum){
            this.node = node;
            this.sum = sum;
        }
    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        pair ans = solve(root,0,limit);
        return ans.node;
    }
    pair solve(TreeNode root, int uppersum, int limit){
        if(root == null) return new pair(null,Integer.MIN_VALUE);
        
        pair left = solve(root.left,uppersum + root.val, limit);
        pair right = solve(root.right, uppersum + root.val, limit);
        root.left = left.node;
        root.right = right.node;
        int max = Math.max(left.sum,right.sum);
        
        if((max == Integer.MIN_VALUE ? 0 : max) + root.val + uppersum < limit){
            return new pair(null,(max == Integer.MIN_VALUE ? 0 : max) + root.val);
        }
        else return new pair(root,(max == Integer.MIN_VALUE ? 0 : max) + root.val);
    }
}