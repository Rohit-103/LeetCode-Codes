class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int n = nums.size();
        vector<vector<int>>ans;
        unordered_map<int,int>map;
        for(int i=0;i<n;i++){
            map[nums[i]] = i;
        }
        // for(auto p : map){
        //     cout<<p.first << "->" << p.second<<endl;
        // }
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int tar = -nums[i] - nums[j];
                // cout<<tar<<endl;
                if(map.find(tar)!=map.end() && map[tar] > j){
                    // cout<<map[tar]<<endl;
                    ans.push_back({nums[i],nums[j],tar});
                }
                j = map[nums[j]];
            }
            i = map[nums[i]];
        }
        return ans;
    }
};