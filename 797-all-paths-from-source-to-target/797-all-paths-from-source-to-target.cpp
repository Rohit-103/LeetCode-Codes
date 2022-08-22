class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        vector<vector<int>>ans;
        vector<int>curr;
        dfs(ans,0,curr,graph,graph.size());
        return ans;
    }
    void dfs(vector<vector<int>>&ans, int src, vector<int>&curr,vector<vector<int>>& graph,int n){
        curr.push_back(src);
        if(src == n-1) ans.push_back(curr);
        for(int i=0;i<graph[src].size();i++){
            dfs(ans,graph[src][i],curr,graph,n);
        }
        curr.pop_back();
    }
};