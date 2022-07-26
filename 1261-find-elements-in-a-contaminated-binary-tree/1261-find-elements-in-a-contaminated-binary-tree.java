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
class FindElements {
    HashSet<Integer>set;
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        solve(root,set,0);
    }
    public void solve(TreeNode root, HashSet<Integer>set, int x){
        if(root == null) return;
        set.add(x);
        solve(root.left,set,2*x+1);
        solve(root.right,set,2*x+2);
    }
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */