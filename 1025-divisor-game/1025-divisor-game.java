class Solution {
    public boolean divisorGame(int n) {
        boolean [] dp = new boolean [n+1];
        dp[1] = false;
        for(int i=2;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                if(i%j == 0 && dp[i-j] == false){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
   
}