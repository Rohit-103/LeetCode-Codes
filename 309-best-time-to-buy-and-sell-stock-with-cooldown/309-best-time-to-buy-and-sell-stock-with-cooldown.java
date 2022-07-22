class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 1 - buy
        // 0 - not buyed
        int[][] dp = new int[2][n];
        return solve(prices, 0, 0, dp);
    }
    public int solve(int[] prices, int i, int state, int[][] dp){
       if(i >= prices.length) return 0;
       int a = solve(prices, i+1,state,dp);
        int b = 0;
       if(dp[state][i] != 0) return dp[state][i];
       if(state == 0){
           b = solve(prices,i+1,1-state,dp) - prices[i];
       }
       else{
           b = solve(prices,i+2,1-state,dp) + prices[i];
       }
       return dp[state][i] = Math.max(a,b);
    }
}