#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
        Node*left;
        Node*right;
    Node(){
        left = NULL;
        right = NULL;
    }
};
class Trie{
    public:
    Node*root;
    Trie(){
        root = new Node();
    }
    void insert(int n){
        Node*temp = root;
        for(int i = 31;i>=0;i--){
            int bit = ((n>>i) & 1);
            if(bit == 0){
                // search for 1
                if(temp->left == NULL){
                    temp->left = new Node();
                }
                temp = temp->left;
            }
            else{
                if(temp->right == NULL){
                    temp->right = new Node();
                }
                temp = temp->right;
            }
        }
    }
    int search(int n){
        int current_ans = 0;
        Node*temp = root;
        for(int i=31;i>=0;i--){
            int bit = (n>>i)&1;
            //cout<<bit;
            if(bit == 0){
                // look for 1
                if(temp->right != NULL){
                    temp = temp->right;
                    current_ans += (1<<i);
                }
                else temp = temp->left;
            }
            else{
                if(temp->left != NULL){
                    temp = temp->left;
                    current_ans += (1<<i);
                }
                else{
                    temp = temp->right;
                }
            }
        }
        cout<<endl<<current_ans<<endl;
        return current_ans;
    }
};



class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {
    int ans = 0;
    Trie t;
    for(int ele : nums){
       t.insert(ele);
       int res = t.search(ele);
       if(res > ans){
           // cout<<ele<<" "<<res<<endl;
           ans = max(res,ans);
       }
    }
    Node*temp = t.root;
    // while(temp->left != NULL || temp->right != NULL){
    //     if(temp->right != NULL){cout<<1<<endl; temp = temp->right;}
    //     else{ cout<<0<<endl; temp = temp->left; } 
    // }
    return ans;
    }
};