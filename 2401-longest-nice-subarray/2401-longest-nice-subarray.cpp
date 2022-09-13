class Solution {
public:
    int longestNiceSubarray(vector<int>& nums) {
        int used = 0, j = 0, i = 0;
        int ans = 0;
        for(int i=0;i<nums.size();i++){
            while((used & nums[i]) != 0){
                used ^= nums[j++];
            }
            used |= nums[i];
            ans = max(ans,i-j+1);
        }
        return ans;
    }
};