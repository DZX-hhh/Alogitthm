package 力扣.每日一题.Five.Day14;

import java.util.Arrays;

public class Solution691 {
    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        //用n位表示当前状态，若某一位为1则为该字母还没被消费，为0表示已经被消费
        int[] memo = new int[1 << n];
        //初始化的操作;
        Arrays.fill(memo, -1);
        //全部都被消费掉的状态，为""字符串，不需要被消费，即需要的卡片为0
        memo[0] = 0;
        //(1 << n) - 1的状态就是111...111 (n个1)表示当前没有被消费掉的字母
        //即传入target字符串
        int res = dfs(target, stickers, memo, (1 << n) - 1);
        //由于初始化res为n + 1,又因为只有当前卡片消费了target字母才会递归消费，所以均不能消费后，res为n + 1
        return res <= n ? res : -1;
    }

    /**
     * @param target   目标字母
     * @param stickers 当前卡片
     * @param memo     记忆化数组
     * @param mask     二进制数状态压缩
     * @return 最少消费几张stickers
     */
    private int dfs(String target, String[] stickers, int[] memo, int mask) {
        int n = target.length();
        //如果没有记忆到，则执行逻辑
        if (memo[mask] < 0) {
            //作为最后判断的依据，若res比n+1小，说明有被消费掉的字母，如果没有变小，则说明不能被消费
            int res = n + 1;
            int sn = stickers.length;
            for (int i = 0; i < sn; ++i) {
                //获取剩余没被使用的字符left，这里初始化赋值
                int left = mask;
                int[] cn = new int[26];
                //记录当前卡片的cn个数
                int ssn = stickers[i].length();
                for (int j = 0; j < ssn; ++j) {
                    ++cn[stickers[i].charAt(j) - 'a'];
                }
                for (int j = 0; j < n; ++j) {
                    //mask >> j & 1表示获取当前target的第j个字母，为1表示未被消费，为0表示被消费
                    //cn[] > 0 表示当前卡片的字母是够的，所以可以在使用一张该卡片的情况下消费掉cn[]这么多的对应字母
                    int index = target.charAt(j) - 'a';
                    if (((mask >> j) & 1) == 1 && cn[index] > 0) {
                        //减去当前卡片当前字母的剩余数量
                        --cn[index];
                        //表示当前target的低位j位字母被消费掉了，如111...110。
                        left ^= 1 << j;
                    }
                }
                //left如果小于mask，说明中间有的字母被消费掉了，所以可以继续消费其他卡片
                if (left < mask) {
                    //当前剩余字母消费情况由二进制left确定，如110011...10
                    //传入剩余字母情况left，进行递归
                    //+1表示只消费了一张卡片，dfs返回的值为最少的卡片数
                    res = Math.min(res, dfs(target, stickers, memo, left) + 1);
                }
            }
            //做记忆化处理
            memo[mask] = res;
        }
        //说明已经计算过了，直接返回
        return memo[mask];
    }
}