class Node{
    public:
    char c;
    unordered_map<char,Node*>m;
    bool isTerminal;
    Node(char data){
        c = data;
        isTerminal = false;
    }
};
class Trie {
public:
    Node*root;
    Trie() {
        root = new Node('\0');
    }
    
    void insert(string word) {
        Node*temp = root;
        for(char ch : word){
            if(temp->m.count(ch) == false){
                temp->m[ch] = new Node(ch);
            } 
            temp = temp->m[ch];
        }
        temp->isTerminal = true;
    }
    
    bool search(string word) {
        Node*temp = root;
        for(char ch : word){
            if(temp->m.count(ch) == false) return false;
            temp = temp->m[ch];
        }
        return temp->isTerminal;
    }
    
    bool startsWith(string prefix) {
        Node*temp = root;
        for(char ch : prefix){
            if(temp->m.count(ch) == false) return false;
            temp = temp->m[ch];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */