class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int ans = 0;
        int count = 0;
        HashSet<Integer>set = new HashSet<>();
        int[][] dp = new int[n][n];
        for(int i=0;i<mines.length;i++){
            set.add(mines[i][0]*n + mines[i][1]);
        }
        for(int i=0;i<n;i++){
            count = 0;
            for(int j=0;j<n;j++){
                count = set.contains(i*n + j) ? 0 : count+1;
                dp[i][j] = count;
            }
            count = 0;
            for(int j = n-1;j>=0;j--){
                count = set.contains(i*n+j) ? 0 : count+1;
                dp[i][j] = Math.min(dp[i][j],count);
            }
        }
        for(int j=0;j<n;j++){
            count = 0;
            for(int i=0;i<n;i++){
                count = set.contains(i*n + j) ? 0 : count+1;
                dp[i][j] = Math.min(dp[i][j],count);
            }
            count = 0;
            for(int i=n-1;i>=0;i--){
                count = set.contains(i*n + j) ? 0 : count+1;
                dp[i][j] = Math.min(dp[i][j],count);
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}