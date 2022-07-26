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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> q = new LinkedList<>();
        if(depth == 1){
            TreeNode head = new TreeNode(val);
            head.left = root;
            return head;
        }
        q.add(root);
        int curht = 1;
        TreeNode temp;
        while(q.size()>0){
            int size = q.size();
            if(curht == depth-1){
                break;
            }
            for(int i=0;i<size;i++){
                temp = q.poll();
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            curht++;
        }
        TreeNode node;
        while(q.size()>0){
            temp = q.poll();
                node = new TreeNode(val);
                node.left = temp.left;
                temp.left = node;
                node = new TreeNode(val);
                node.right = temp.right;
                temp.right = node;
            
        }
        return root;
    }
}