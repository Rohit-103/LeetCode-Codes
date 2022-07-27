class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        HashMap<Character,Deque<String>>map = new HashMap<>();
        Deque<String> dq;
        for(String str: words){
            char c = str.charAt(0);
            if(map.containsKey(c) == false) map.put(c,new LinkedList<>());
            map.get(c).addLast(str);
        }
        for(char ch : s.toCharArray()){
            dq = map.get(ch);
            if(dq == null) continue;
            int size = dq.size();
            for(int i=0;i<size;i++){
                String poll = dq.removeFirst();
                //System.out.println(ch + " " + poll);
                if(poll.length() == 1){
                    ans++;
                    continue;
                }
                if(map.containsKey(poll.charAt(1)) == false) map.put(poll.charAt(1),new LinkedList<>());
                map.get(poll.charAt(1)).addLast(poll.substring(1));
            }
        }
        return ans;
    }
}