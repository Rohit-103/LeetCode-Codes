class LRUCache {
    public class node{
        int key;
        int val;
        node prev = null;
        node next = null;
        public node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
     HashMap<Integer,node>map;
     int size = 0;
    static node head;
    static node tail;
    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<>();
        head = new node(0,0);
        tail = new node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
           node temp = map.get(key);
           int tr = temp.val;
           remove(temp);
           addFirst(temp);
           return tr;
       }
       return -1;
    }
    
    public void put(int key, int val) {
        node newnode = new node(key,val);
        if(map.containsKey(key)){
            node temp = map.get(key);
            remove(temp);
        }
        else if(map.size() == size){
            int k = tail.prev.key;
            remove(tail.prev);
            map.remove(k);
        }
        addFirst(newnode);
        map.put(key,newnode);
    }
    public static void remove(node n){
        node behind = n.prev;
        node ahead = n.next;
        n.prev = null;
        n.next = null;
        behind.next = ahead;
        ahead.prev = behind;
    }
    public static void addFirst(node n){
        node temp = head.next;
        head.next = n;
        n.next = temp;
        n.prev = head;
        temp.prev = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */