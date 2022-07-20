class Solution {
    public int maxEnvelopes(int[][] nums) {
        //Sort second
        Arrays.sort(nums,(a,b)->{
           if(a[1] == b[1]){
               return b[0]-a[0];
           } 
           else return a[1]-b[1];
        });
        int ans = 1;
        for(int i=1;i<nums.length;i++){
            int cidx = lb(nums,0,ans-1,nums[i][0]);
            if(cidx == ans){
                ans++;
            }
            nums[cidx] = nums[i];
        }
        return ans;
    }
    public int lb(int[][] nums, int lo, int hi, int tar){
        int mid;
        while(hi-lo>1){
            mid = (lo+hi)/2;
            if(nums[mid][0]<tar){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        if(nums[lo][0]>=tar) return lo;
        else if(nums[hi][0]>=tar) return hi;
        else return hi+1; 
    }
}