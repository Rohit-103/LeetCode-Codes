class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<vector<int>>ans;
        int n = nums.size();
        for(int i=0;i<n;i++){
            if(i!=0 && nums[i] == nums[i-1]) continue;
            int tar = -nums[i];
            int lo = i+1;
            int hi = n-1;
            bool flag = false;
            while(lo < hi){
                if(nums[lo] + nums[hi] == tar){
                    if(flag == true && nums[lo] == nums[lo-1]){
                        lo++; hi--;
                        continue;
                   }
                   flag = true;
                   ans.push_back({nums[i],nums[lo],nums[hi]});
                    lo++;
                    hi--;
                }
                else if(nums[lo] + nums[hi] > tar){ hi--; flag = false; } 
                else{ lo++; flag = false; }
            }
        }
        return ans;
    }
};