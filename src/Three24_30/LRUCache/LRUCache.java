package Three24_30.LRUCache;

/**
 * 用链表来实现，从头删除，从尾部添加
 * 即最近最少未使用的放在头部，尾部是最进才使用的
 */
class LRUCache {

    /**
     * 链表节点实现类，双向链表
     */
    private class Node{
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value, Node next,Node prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
    //头节点，无实际内容，负责删除
    Node head = new Node();
    //尾节点，无实际内容，负责添加
    Node tail = new Node();
    //实际的链表长度
    int size = 0;
    //最大链表长度
    int maxCapacity;
    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.maxCapacity = capacity;
    }

    /**
     * 1，获取
     * 2，将元素放入链表尾部
     */
    public int get(int key) {
       int res = -1;
       //寻找，找到的话重新赋值
        Node tmp = head;
        while (tmp.next!=tail){
            tmp = tmp.next;
            if(tmp.key == key){
                res = tmp.value;
                break;
            }
        }
        //找到的话将元素放入末尾
        if(res!=-1){
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
            this.size--;
            putEnd(tmp);
        }
        return res;
    }

    public void put(int key, int value) {
        //寻找是否存在，存在的话更新其数据
        if(get(key)!=-1){
            tail.prev.value = value;
            return;
        }
        //未到最大容量直接放入末尾
        if(this.size < maxCapacity){
            putEnd(new Node(key,value));
        }else {
            //否则先删除再放入
            //删除头部
            delEnd();
            putEnd(new Node(key,value));
        }
    }
    /**
     * 元素放入末尾
     */
    private void putEnd(Node e){
       e.prev = tail.prev;
       e.next = tail;
       tail.prev.next = e;
       tail.prev = e;
       this.size++;
    }
    /**
     * 元素删除头部
     */
    private void delEnd(){
        //如果头部没有元素
        if(size == 0){
            return ;
        }else {
            //删除头部元素
            Node tmp = head.next;
            tmp.next.prev = head;
            head.next = tmp.next;
            this.size--;
            return ;
        }
    }
    public void printLink(){
        Node tmp = head.next;
        System.out.println("size="+size);
        while (tmp!=tail){
            System.out.println("key="+tmp.key+"value="+tmp.value);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.printLink();
        cache.put(2, 2);
        cache.printLink();
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.printLink();
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);

    }
}

