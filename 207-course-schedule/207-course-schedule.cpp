class Solution {
public:
    bool dfs(vector<int>adj[], vector<bool>& vis, vector<bool>&st, int idx){
        vis[idx] = true;
        st[idx] = true;
        
        for(int nbr : adj[idx]){
            if(vis[nbr] == true && st[nbr] == true){
                return true;
            }
            else if(! vis[nbr]){
                if(dfs(adj,vis,st,nbr) == true) return true;
            }
        }
        st[idx] = false;
        return false;
    }
    bool canFinish(int n, vector<vector<int>>& pre) {
        vector<int>adj[n];
        for(auto v : pre){
            adj[v[1]].push_back(v[0]);
        }
        vector<bool> vis(n,false);
        vector<bool>st(n,false);
        for(int i=0;i<n;i++){
            if(!vis[i]) if(dfs(adj,vis,st,i) == true) return false;
        }
        return true;
    }
};