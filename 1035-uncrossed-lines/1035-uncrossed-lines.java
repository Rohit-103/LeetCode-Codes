class Solution {
    int res;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        res = 0;
        int[][] dp = new int[nums1.length][nums2.length];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return solve(nums1,nums2,0,0,dp);
    }
    public int solve(int[] nums1, int[] nums2, int i, int j, int[][] dp){
        if(j == nums2.length || i == nums1.length){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int equal = 0, jnotcome = 0, inotcome = 0;
            if(nums1[i] == nums2[j]){
                equal = solve(nums1,nums2,i+1,j+1,dp)+1;
            }
            jnotcome = solve(nums1,nums2,i,j+1,dp);
            inotcome = solve(nums1,nums2,i+1,j,dp);
            return dp[i][j] = Math.max(jnotcome,Math.max(inotcome,equal));
    }
}