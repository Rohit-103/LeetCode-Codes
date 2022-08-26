class Node{
    public:
    char c;
    Node* arr[26] = {NULL};
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
        // for(int i=0;i<26;i++){
        //     cout<<root->arr[i]<<" ";
        // }
    }
    
    void insert(string word) {
        Node*temp = root;
        for(char ch : word){
            if(temp->arr[ch-'a'] == NULL){
                temp->arr[ch-'a'] = new Node(ch);
            } 
            temp = temp->arr[ch-'a'];
        }
        temp->isTerminal = true;
    }
    
    bool search(string word) {
        Node*temp = root;
        for(char ch : word){
            if(temp->arr[ch-'a'] == NULL) return false;
            temp = temp->arr[ch-'a'];
        }
        return temp->isTerminal;
    }
    
    bool startsWith(string prefix) {
        Node*temp = root;
        for(char ch : prefix){
            if(temp->arr[ch-'a'] == NULL) return false;
            temp = temp->arr[ch-'a'];
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