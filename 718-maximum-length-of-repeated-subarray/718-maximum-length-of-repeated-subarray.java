class Solution {
    static int ans;
    public int findLength(int[] nums1, int[] nums2) {
        ans = 0;
        int[][] dp = new int[nums1.length][nums2.length];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        solve(nums1,nums2,0,0,dp);
        return ans;
    }
    public int solve(int[] nums1, int[] nums2, int i, int j,int[][] dp){
        if(i == nums1.length || j == nums2.length){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(nums1[i] == nums2[j]){
            int a = solve(nums1,nums2,i+1,j+1,dp);
            ans = Math.max(ans,a+1);
            solve(nums1,nums2,i+1,j,dp);
            solve(nums1,nums2,i,j+1,dp);
            return dp[i][j] = a+1;
        }
        else{
            solve(nums1,nums2,i+1,j,dp);
            solve(nums1,nums2,i,j+1,dp);
            return dp[i][j] = 0;
        }
    }
}