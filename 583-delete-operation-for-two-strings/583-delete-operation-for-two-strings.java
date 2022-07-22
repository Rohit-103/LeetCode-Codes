class Solution {
    public int minDistance(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];
        return solve(a,b,0,0,dp);
    }
    public int solve(String a, String b, int i, int j, int[][] dp){
        if(i == a.length() && j == b.length()) return 0;
        if(i == a.length() || j == b.length()) return i == a.length() ? b.length()-j : a.length()-i;
        if(dp[i][j] != 0) return dp[i][j];
        if(a.charAt(i) == b.charAt(j)) return dp[i][j] = solve(a,b,i+1,j+1,dp);
        int x = solve(a,b,i+1,j,dp);
        int y = solve(a,b,i,j+1,dp);
        return dp[i][j] = Math.min(x,y)+1;
    }
}