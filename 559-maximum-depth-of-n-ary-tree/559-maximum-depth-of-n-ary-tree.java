/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        int cur = 0;
        Queue<Node>q = new LinkedList<>();
        if(root == null) return 0;
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node poll = q.poll();
                List<Node>arr = poll.children;
                for(Node c : arr){
                    q.add(c);
                }
            }
            cur++;
        }
        return cur;
    }
}