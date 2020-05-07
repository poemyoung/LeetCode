package Three24_30.LRUCache;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache2 {
    int capacity;
    LinkedList<Integer> queue;
    HashMap<Integer,Integer> map;
    public LRUCache2(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        int res = -1;
        //寻找有没有
        res = map.get(key) == null? -1:map.get(key);
        if(res == -1){
            return res;
        }
        //有的话改变key的优先值
        queue.remove((Integer)key);
        queue.push(key);
        return res;
    }

    public void put(int key, int value) {
        //寻找有没有
        if(queue.contains(key)){
            //有
            map.replace(key,value);
            queue.remove((Integer)key);
            queue.push(key);
        }else {
            //没有
            //长度超界
            if(queue.size() >= this.capacity){
               int p =  queue.removeLast();
               map.remove(p);
            }
            queue.push(key);
            map.put(key,value);
        }
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}
