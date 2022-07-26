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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer>ans = new ArrayList<>();
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode poll = q.poll();
                max = Math.max(max,poll.val);
                if(poll.left !=  null) q.add(poll.left);
                if(poll.right !=  null) q.add(poll.right);
            }
            ans.add(max);
            max = Integer.MIN_VALUE;
        }
        return ans;
    }
}