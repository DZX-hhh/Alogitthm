#### [剑指 Offer 10- II. 青蛙跳台阶问题](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/)

难度简单275

一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 `n` 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

**示例 1：**

```
输入：n = 2
输出：2
```

**示例 2：**

```
输入：n = 7
输出：21
```

**示例 3：**

```
输入：n = 0
输出：1
```

**提示：**

- `0 <= n <= 100`

注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/

**动态规划**

```java
public class T2 {
    /*动态规划,,维护备忘录*/
    int mod = 1000000007;

    public int numWays(int n) {
        if (n <= 1) return 1;
        //备忘录
        int[] dp = new int[n + 1];
        //初始化
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            //第i层的跳法=第i-1层跳一级台阶+第i-2层跳两级台阶
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp[n];
    }
}
```