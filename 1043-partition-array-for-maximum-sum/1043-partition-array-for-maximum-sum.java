class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        return solve(arr,k,0,dp);
    }
    public int solve(int[] arr, int k,int idx,int[] dp){
        if(idx == arr.length) return 0;
        int max = -1;
        int ans = 0;
        int count = 0;
        if(dp[idx]!=0) return dp[idx];
        for(int i=idx;i<arr.length && count<k;i++){
            count++;
            max = Math.max(arr[i],max);
            ans = Math.max(max*count + solve(arr,k,i+1,dp),ans);
        }
        //System.out.println(ans);
        return dp[idx] = ans;
    }
}