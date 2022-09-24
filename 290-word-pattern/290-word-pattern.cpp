class Solution {
public:
    bool wordPattern(string pattern, string s) {
        unordered_map<char,string>map;
        vector<string>words;
        int i = 0;
        string word;
        while(i < s.length()){
            word = "";
            while(i < s.length() && s[i] != ' '){
                word.push_back(s[i]);
                i++;
            }
            words.push_back(word);
            i++;
        }
        if(pattern.length() != words.size()) return false;
        unordered_set<string>set;
        for(int i=0;i<pattern.length();i++){
            char c = pattern[i];
            if(map.count(c)){
                if(map[c] != words[i]) return false;
                else continue;
            }
            else{
                if(set.count(words[i])) return false;
                map[c] = words[i];
                set.insert(words[i]);
            }
        }
        return true;
    }
};   