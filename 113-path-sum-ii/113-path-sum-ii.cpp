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
    void rec(TreeNode*root, int tar, vector<int>&sub, vector<vector<int>>&ans){
        if(root == nullptr) return;
        if(root->left == nullptr && root->right == nullptr){
            if(tar == root->val){
                vector<int>t(sub);
                t.push_back(root->val);
                ans.push_back(t);
            }
            return;
        }
        sub.push_back(root->val);
        rec(root->left,tar-root->val,sub,ans);
        rec(root->right,tar-root->val,sub,ans);
        sub.pop_back();
    }
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<vector<int>>ans;
        if(root == nullptr) return ans;
        vector<int>sub;
        rec(root,targetSum,sub,ans);
        return ans;
    }
};