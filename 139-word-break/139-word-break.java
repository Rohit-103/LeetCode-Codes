class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        boolean[] dp = new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            for(int j = i; j>=0; j--){
                if(set.contains(s.substring(j,i+1)) == true)
                    if(j == 0 || dp[j-1] == true){
                        dp[i] = true;
                        break;
                    }
            }
        }
        return dp[s.length()-1];
    }
}