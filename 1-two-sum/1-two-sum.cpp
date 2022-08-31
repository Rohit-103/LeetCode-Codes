class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int>map;
        // vector<int>ans;
        for(int i=0;i<nums.size();i++){
            if(map.count(target-nums[i]) != 0) return {map[target-nums[i]],i};
            map[nums[i]] = i;
        }
        return {};
    }
};