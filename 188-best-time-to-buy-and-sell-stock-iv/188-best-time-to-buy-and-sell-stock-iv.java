class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // boolean buy - true,  skip,sold - false;
        int[][][] dp = new int[2][n][k+1];
        int ans  = solve(prices, dp,false,0,0,k);
        // for(int[][] arr : dp){
        //     for(int[] ar : arr){
        //         for(int ele : ar) System.out.print(ele + " ");
        //         System.out.println();
        //     }
        //     System.out.println();
        // }
        return ans;
    }
    public int solve(int[] prices,int[][][] dp,boolean bought,int i,int curk, int k){
        if(i == prices.length || k == curk){
            return 0;
        }
        // after buying, we can either skip or sell
        // after selling, we can either skip or buy
        int buy = bought == true ? 1 : 0;
        if(dp[buy][i][curk] != 0) return dp[buy][i][curk];
        // Skip call
        int a = solve(prices,dp,bought,i+1,curk,k);
        int b = 0;
        if(bought == true){
            // selling call
            b = solve(prices,dp,!bought,i+1,curk+1,k) + prices[i];
        }
        else{
           // buying call
           b = solve(prices,dp,!bought,i+1,curk,k) - prices[i];
        }
        return dp[buy][i][curk] = Math.max(a,b);
    }
}
