class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // boolean buy - true,  skip,sold - false;
        int[][] dp = new int[2][n];
        int ans  = solve(prices, dp,false,0,fee);
        // for(int[][] arr : dp){
        //     for(int[] ar : arr){
        //         for(int ele : ar) System.out.print(ele + " ");
        //         System.out.println();
        //     }
        //     System.out.println();
        // }
        return ans;
    }
    
        
    public int solve(int[] prices,int[][] dp,boolean bought,int i,int fee){
        if(i == prices.length){
            return 0;
        }
        int buy = bought == true ? 1 : 0;
        if(dp[buy][i] != 0) return dp[buy][i];
        int a = solve(prices,dp,bought,i+1,fee);
        int b = 0;
        if(bought == true){
            b = solve(prices,dp,!bought,i+1,fee) + prices[i] - fee;
        }
        else{
           b = solve(prices,dp,!bought,i+1,fee) - prices[i];
        }
        return dp[buy][i] = Math.max(a,b);
    }

}