#### [剑指 Offer 46. 把数字翻译成字符串](https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/)

难度中等423

给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

**示例 1:**

```
输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
```

**提示：**

- `0 <= num < 231`

**动态规划**

```java
public class T1 {
    public static int translateNum(int num) {
        if (num < 10) return 1;
        char[] chars = String.valueOf(num).toCharArray();
        int[] dp = new int[chars.length];
        //base case,第一个格子只能跳一格
        dp[0] = 1;
        //初始化dp[1],这个比较特殊,前面只有dp[0]一位
        int t = (chars[0] - '0') * 10 + chars[1] - '0';
        dp[1] = t >= 10 && t <= 25 ? 2 : 1;
        for (int i = 2; i < dp.length; i++) {
            int temp = (chars[i - 1] - '0') * 10 + chars[i] - '0';
            if (temp >= 10 && temp <= 25) {//如果第i个和第i-1个能够成为一个新的结果
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
```