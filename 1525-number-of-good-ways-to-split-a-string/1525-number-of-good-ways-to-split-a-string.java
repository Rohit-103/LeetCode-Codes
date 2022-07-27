class Solution {
    public int numSplits(String s) {
        HashSet<Character>set = new HashSet<>();
        int n = s.length();
        int[] right = new int[n];
        for(int i=n-1;i>=0;i--){
            char c = s.charAt(i);
            set.add(c);
            right[i] = set.size();
        }
        int ans = 0;
        set = new HashSet<>();
        for(int i=0;i<n-1;i++){
            char c = s.charAt(i);
            set.add(c);
            if(set.size() == right[i+1]) ans++;
        }
        return ans;
    }
}