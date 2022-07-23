class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(s,set,0,dp);
    }
    public boolean solve(String s, HashSet<String>set, int idx,int[] dp){
        
        if(idx == s.length()) return true;
        if(dp[idx] != -1) return dp[idx] == 1 ? true : false;
        for(int i = idx;i<s.length();i++){
            if(set.contains(s.substring(idx,i+1)) == true){
                boolean ans = solve(s,set,i+1,dp);
                if(ans == true){
                    dp[idx] = 1;
                    return true;
                }
            }
        }
        dp[idx] = 0;
        return false;
    }
}