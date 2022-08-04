class Solution {
    public boolean isInterleave(String s1, String s2, String s3){
        int n = s1.length();
        int m = s2.length();
        if(s1.length() + s2.length() != s3.length()) return false;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }
        return solve(s1,s2,s3,0,0,dp);
    }
    public boolean solve(String s1, String s2,String s3, int i, int j, int[][] dp){
        if(i == s1.length() && j == s2.length()) return true;
        if(i == s1.length()){
            if(s2.substring(j).equals(s3.substring(i+j)) == true) 
            {
                return true;
            }
            return false;
        }
        if(j == s2.length()){
            if(s1.substring(i).equals(s3.substring(i+j)) == true) 
            {
                return true;
            }
            return false;
        }
        
        if(dp[i][j] != -1) return dp[i][j]==0?false:true;
        boolean ans = false;
        if(s1.charAt(i) == s3.charAt(i+j)){
            ans |= solve(s1,s2,s3,i+1,j,dp);
        }
        if(s2.charAt(j) == s3.charAt(i+j)){
            ans |= solve(s1,s2,s3,i,j+1,dp);
        }
        dp[i][j] = ans == true ? 1 : 0;
        return ans;
    }
}