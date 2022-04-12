package Leetcode.Study.LFU缓存;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    // key 到 val 的映射，我们后文称为 KV 表
    HashMap<Integer, Integer> keyToVal;
    // key 到 freq 的映射，我们后文称为 KF 表
    HashMap<Integer, Integer> keyToFreq;
    // freq 到 key 列表的映射，我们后文称为 FK 表
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 记录最小的频次
    int minFreq;
    // 记录 LFU 缓存的最大容量
    int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    //增加访问次数
    public void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        //更新KF表,这里访问了key,因此对应的freq必须+1
        keyToFreq.put(key, freq + 1);

        //更新FK表
        //将key从freq对应的列表中删除
        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);

        //如果freq对应的key列表为空,那么移除这个freq
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            /*
             * 更新MinFreq
             */
            //如果这个freq恰好是MinFreq,又因为前面访问过key,使得freq+1,因此MinFreq也需要+1
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }

    //移除访问次数最小的key
    private void removeMinFreqKey() {
        //freq最小的key列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        //其中最先被插入的key应该被淘汰,,,时间最长
        int deleteKey = keyList.iterator().next();
        /*
         * 更新FK表,删除最早出现的频率最低的key
         */
        keyList.remove(deleteKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);//这里不需要修稿MinFreq
        }
        //更新KV表
        keyToVal.remove(deleteKey);
        //删除KF表
        keyToFreq.remove(deleteKey);
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        //增加key访问的次数freq+1
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0) return;
        /*
         * 若key已存在,修改对应的val即可
         */
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            //key对应的freq+1
            increaseFreq(key);
            return;
        }
        //如果key不存在,插入
        //容量已满,淘汰一个freq最小的key
        if (cap <= keyToVal.size()) {
            removeMinFreqKey();
        }
        //插入key以及对应的val,对应的freq为1
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        //插入freqToKeys表
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());//新建一个hash集合
        freqToKeys.get(1).add(key);//将freq为1的集合新增一个key
        //插入新key后最小的freq为1
        /**
         * 只有在put操作下才会调用removeMinFreqKey(),在这里更新minFreq就可以了
         */
        this.minFreq = 1;
    }
}
