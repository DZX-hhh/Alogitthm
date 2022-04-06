package Leetcode.LeetcodeStudy.LRU缓存;

import java.util.LinkedHashMap;

public class LRUCache2 {
    int cap;
    /*
     * 底层原理是双向链表+hashmap存的隐射
     */
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache2(int cap) {
        this.cap = cap;
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            cache.put(key, val);
            makeRecently(key);
            return;
        }
        if (cap <= cache.size()) {
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, val);
    }
}
