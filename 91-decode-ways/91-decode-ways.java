class Solution {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int[] dp = new int[s.length()+1];
        int n = s.length();
        dp[n] = 1;
        dp[n-1] = arr[n-1]=='0'?0:1;
        for(int i=n-2;i>=0;i--){
            if(arr[i] == '0'){
                continue;
            }
            else dp[i] = ((Integer.parseInt(s.substring(i,i+2)) <= 26) ? dp[i+2] : 0) + dp[i+1];
        }
        return dp[0];
    }
}