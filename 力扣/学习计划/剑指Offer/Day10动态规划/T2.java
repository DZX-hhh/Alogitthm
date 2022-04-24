package 力扣.学习计划.剑指Offer.Day10动态规划;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class T2 {
    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        LinkedList<Character> res = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (!res.contains(c)) {
                res.add(c);
                max = Math.max(max, res.size());
                continue;
            }
            max = Math.max(max, res.size());
            while (res.contains(c)) {
                char d = s.charAt(left);
                res.removeFirst();
                left++;
            }
            res.add(c);
            max = Math.max(max, res.size());
        }
        return max;
    }

    //动态规划
    public int lengthOfLongestSubstring2(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int res = 0, tempDp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = map.getOrDefault(s.charAt(j), -1);//获取`j`的上一个重复元素位置
            map.put(s.charAt(j), j);//更新哈希表,,字母j出现的位置

            //这里可以认为tempDp为dp[j]:  !!含义:以下标j结尾的字符,最大不重复的字串长度
            //1.如果当前j-i长度`>`dp[j-1],,那么意思就是  j固定,i超出了dp[j-1]长度的范围了,,那么dp[j-1]也有重复
            //`dp[j]=dp[j-1]+1`
            //2.如果当前j-i的长度`<`dp[j-1],那么意思就是  j固定,i在dp[j-1]长度的范围之内
            // 相比于dp[j-1],不出现重复的长度就是`j-i`
            //3.i为-1,未出现重复,,显然可以直接dp[j-1]+1
            tempDp = tempDp < j - i ? tempDp + 1 : j - i;
            res = Math.max(res, tempDp);
        }
        return res;
    }
}
