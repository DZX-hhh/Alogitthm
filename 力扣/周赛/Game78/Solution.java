package 力扣.周赛.Game78;

import java.util.Arrays;

public class Solution {
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        if (s.length() < k) {
            return 0;
        }
        int res = 0;
        int left = 0, right = k - 1;
        int i = Integer.parseInt(s.substring(left, right + 1));
        System.out.println(i);
        if (i != 0 && num % i == 0) {
            res++;
        }
        while (right < s.length()) {
            right++;
            left++;
            if (right < s.length() && (Integer.parseInt(s.substring(left, right + 1)) != 0) && num % Integer.parseInt(s.substring(left, right + 1)) == 0) {
                res++;
            }
        }
        return res;
    }

    public int waysToSplitArray(int[] nums) {
        if (nums.length == 2) {
            return nums[0] >= nums[1] ? 1 : 0;
        }
        int res = 0;
        long[] presum = new long[nums.length + 1];
        for (int i = 1; i < presum.length; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (presum[i + 1] >= (presum[nums.length] - presum[i + 1])) {
                res++;
            }
        }
        return res;
    }


    /*
        贪心 & 滑动窗口
        贪心: 毯子的左端点一定和某组瓷砖的左端点一致
        因此我们枚举毯子的左端点和哪组瓷砖的左端点一致，并通过滑动窗口维护此时毯子右边最多覆盖到哪组瓷砖，取最大值作为答案即可。
        复杂度O(nlogn)（一开始要排序）。
     */
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (arr1, arr2) -> {
            return arr1[0] - arr2[0];
        });
        int sum = 0, res = 0;
        int left = 0, right = 0, n = tiles.length;
        while (right < n) {//开始滑动窗口
            //左边起始下标,以及最长右边结束下标
            int leftStart = tiles[left][0], rightToUse = leftStart + carpetLen - 1;
            //1. 如果没有覆盖完,,表示当前right组瓷砖还没消费完毯子,就已经遍历完了
            if (tiles[right][1] <= rightToUse) {
                //这里sum累加当前right组地砖的数目
                sum += tiles[right][1] - tiles[right][0] + 1;
                right++;
                res = Math.max(res, sum);//更新答案
            } else {
                //2. 覆盖部分,表示毯子被消费完了,不够长,但是又超多了right组瓷砖的起始点,无法掩盖全部
                if (rightToUse > tiles[right][0]) {
                    res = Math.max(res, sum + rightToUse - tiles[right][0] + 1);//更新答案
                }
                //3. 调整下一个区间开头
                sum -= tiles[left][1] - tiles[left][0] + 1;
                left++;
            }
        }
        return res;
    }


    /*
        字符集比较小，因此枚举字符对进而计算答案。
        设ch1为最多字符，ch2为最少字符。
        dp[0] 表示连续ch1字符的数量
        dp[1] 表示当前位置结尾的最大波动值

     */
    public int largestVariance(String s) {
        int n = s.length(), res = 0;
        //分别暴力枚举连续出现出现次数最多的字符ch1  出现次数最少的字符ch2
        for (char ch1 = 'a'; ch1 <= 'z'; ch1++) {
            for (char ch2 = 'a'; ch2 <= 'z'; ch2++) {
                if (ch1 == ch2) {//同一字符,,跳过
                    continue;
                }
                //dp[0] 表示连续出现最多ch1字符的数量
                //dp[1] 表示当前位置结尾的最大波动值
                int[] dp = {0, -114514};
                for (char c : s.toCharArray()) {
                    if (c == ch2) {
                        //dp[1]-1表示最大波动值-1,也就是说ch2任然是最少个数,ch1数量不变,ch2+1,因此最大波动-1
                        //dp[0]-1表示连续出现最多ch1字符数量-1   也就是ch2不再是最少的个数,而是另外其他的字符
                        //二者取最大值
                        dp[1] = Math.max(dp[1] - 1, dp[0] - 1);
                        dp[0] = 0;//中断连续出现最多次数ch1字符
                    } else if (c == ch1) {
                        //出现最多字符ch1次数+1
                        dp[0]++;
                        dp[1]++;
                    }
                    res = Math.max(res, dp[1]);
                }
            }
        }
        return res;
    }
}