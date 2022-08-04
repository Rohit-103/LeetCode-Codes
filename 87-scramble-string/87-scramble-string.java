class Solution {
    HashMap<String,Boolean>map;
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        map = new HashMap<>();
        return solve(s1,s2);
    }
    public boolean solve(String s1, String s2){
        if(s1.equals(s2)) return true;
        int[] f1 = new int[26];
        for(int i=0;i<s1.length();i++){
            f1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            f1[s2.charAt(i)-'a']--;
        }
        String key = s1 + " " + s2;
        for(int ele : f1) if(ele != 0){
            map.put(key,false);
            return false;
        }
        if(map.containsKey(key) == true) return map.get(key);
        int m = s1.length();
        for(int i=1;i<s1.length();i++){
            if((solve(s1.substring(0,i),s2.substring(0,i)) && solve(s1.substring(i),s2.substring(i)))){
                map.put(key,true);
                return true;
            }
            if(solve(s1.substring(0,i),s2.substring(m-i)) && solve(s1.substring(i),s2.substring(0,m-i))){
                map.put(key,true);
                return true;
            }
        }
        map.put(key,false);
        return false;
    }
}