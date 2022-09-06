/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool dfs(TreeNode*root){
        if(root == nullptr) return false;
        bool lc = dfs(root->left);
        if(lc == false) root->left = nullptr;
        bool rc = dfs(root->right);
        if(rc == false) root->right = nullptr;
        bool self = root->val == 1;
        if((lc || rc || self) == false) return false;
        else return true;
    }
    TreeNode* pruneTree(TreeNode* root) {
        bool flag = dfs(root);
        if(flag) return root;
        else return nullptr;
    }
};