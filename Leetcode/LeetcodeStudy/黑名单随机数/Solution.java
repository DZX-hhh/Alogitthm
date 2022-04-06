package Leetcode.LeetcodeStudy.黑名单随机数;

import java.util.HashMap;
import java.util.Random;

public class Solution {
    int finalSize;//除去黑名单后最终的数组大小
    HashMap<Integer, Integer> blackEleToLastindex;//映射关系,使得数组逻辑上紧凑

    /**
     * 将黑名单的元素移到数组的最末端,同时用一个哈希表映射
     * !!!黑名单映射到白名单的位置
     *
     * @param n         n个数
     * @param blacklist 黑名单
     */
    public Solution(int n, int[] blacklist) {
        finalSize = n - blacklist.length;
        blackEleToLastindex = new HashMap<>();
        int lastindex = n - 1;

        //初始化map
        for (int blackElement : blacklist) {
            blackEleToLastindex.put(blackElement, 0);
        }

        for (int blackElement : blacklist) {

            //跳过在[finalSize,,,]后的黑名单的数
            if (blackElement >= finalSize) {
                continue;
            }
            //映射表为黑名单,,如果在[finalSize,n-1]也是黑名单,需要跳过,目的是寻找白名单的数
            while (blackEleToLastindex.containsKey(lastindex)) {
                lastindex--;
            }
            blackEleToLastindex.put(blackElement, lastindex);
            lastindex--;
        }
    }

    public int pick() {
        Random random = new Random();
        int index = random.nextInt(finalSize);//在[0,finalSize]随机抽取一个数
        if (blackEleToLastindex.containsKey(index)) {//如果在映射表中,说明是黑名单,返回对应的映射的白名单的位置
            return blackEleToLastindex.get(index);
        }
        return index;//不存在的话,说明是白名单,直接返回就可以
    }
}
