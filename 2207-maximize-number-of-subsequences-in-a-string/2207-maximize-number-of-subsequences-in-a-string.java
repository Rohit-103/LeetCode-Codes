class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        int n = text.length();
        long cnt1 = 0, cnt2 = 0;
        long ans = 0;
        for(char ch : text.toCharArray()){
            if(ch == pattern.charAt(1) && ch == pattern.charAt(0)){
                ans += cnt1;
                cnt1++;
            }
            else if(ch == pattern.charAt(1)){
                ans += cnt1;
                cnt2++;
            }
            else if(ch == pattern.charAt(0)){
                cnt1++;
            }
        }
        return Math.max(cnt1,cnt2) + ans;
    }
}