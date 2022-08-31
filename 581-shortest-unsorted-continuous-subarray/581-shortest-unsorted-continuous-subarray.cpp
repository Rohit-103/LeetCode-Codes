class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int minn = INT_MAX;
        int maxx = INT_MIN;
        if(nums.size() <= 1) return 0;
        if(nums[0] > nums[1]){ minn = nums[0]; maxx = nums[0];}
        for(int i=1;i<nums.size()-1;i++){
            if(nums[i]<nums[i-1] || nums[i]>nums[i+1]){
                minn = min(minn,nums[i]);
                maxx = max(maxx,nums[i]);
            }
        }
        if(maxx == INT_MIN) return 0;
        int n = nums.size();
        if(nums[n-1] < nums[n-2]){
            minn = min(minn,nums[n-1]);
            maxx = max(maxx,nums[n-1]);
        }

        // cout<<minn<<" "<<maxx<<endl;
        int lo = 0;
        int hi = n;
        for(int i=0;i<nums.size();i++){
            if(minn < nums[i]) {lo = i; break;}
        }
        for(int i=n-1;i>=0;i--){
            if(maxx > nums[i]) {hi = i; break;}
        }
        // cout<<lo<<" "<<hi <<endl;
        return hi-lo + 1;
    }
};