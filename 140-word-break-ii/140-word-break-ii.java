class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String>set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        List<String>[] dp = new ArrayList[s.length()];
        for(int i=0;i<s.length();i++){
            dp[i] = new ArrayList<>();
            for(int j=i;j>=0;j--){
                String substr = s.substring(j,i+1);
                if(set.contains(substr) == true){
                    if(j == 0) dp[i].add(substr);
                    else{
                        List<String>list = dp[j-1];
                        for(String str : list){
                            dp[i].add(str + " " + substr);
                        }
                    }
                }
            }
        }
        return dp[s.length()-1];
    }
}