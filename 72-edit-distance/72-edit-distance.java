class Solution {
    int ans;
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return solve(word1, word2,0,0,dp);
    }
    public int solve(String a, String b, int i, int j,int[][] dp){
        if(i == a.length() && j == b.length()){
            return 0;
        }
        if(j == b.length() || i == a.length()){
            if(j == b.length()) return a.length()-i;
            else return b.length()-j;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return dp[i][j] = solve(a,b,i+1,j+1,dp);
        else{
            int x = solve(a,b,i+1,j+1,dp) + 1;
            int y = solve(a,b,i+1,j,dp) + 1;
            int z = solve(a,b,i,j+1,dp) + 1;
            return dp[i][j] = Math.min(x,Math.min(y,z));
        }
    }
}