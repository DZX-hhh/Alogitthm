package LeetCode.周赛.Game276;

public class Solution {
    /*
        先补齐,再字符串截取
     */
    public String[] divideString(String s, int k, char fill) {
        StringBuilder t = new StringBuilder(s);
        while (t.length() % k != 0) {
            t.append(fill);//这里fill未必是一个字符
        }
        String[] res = new String[t.length() / k];
        for (int i = 0; i < res.length; i++) {
            res[i] = t.substring(i * k, i * k + k);
        }
        return res;
    }

    /*
        贪心,有后往前遍历
     */
    public int minMoves(int target, int maxDoubles) {
        if (target == 1) {
            return 0;
        }
        if (maxDoubles == 0) {
            return target - 1;
        }
        int t = target, step = 0;
        while (t > 1 && maxDoubles != 0) {
            if (t % 2 == 0) {
                maxDoubles--;
                t /= 2;
            } else {
                t--;
            }
            step++;
        }
        return step + t - 1;
    }

    /*
        动态规划:当前问题跳或者不跳的最大值
        递推方程:dp[i]=max(dp[i+1],question[i][0]+dp[i+questions[i][1]])
                         当前跳过:最大值等于下一个最大值
                         当前不跳:获取分数+后question[i][1]个最大值
     */
    public long mostPoints(int[][] questions) {
        long dp[] = new long[questions.length + 10001];
        for (int i = questions.length - 1; i >= 0; i--) {//这里由后往前遍历,因为前面的依赖后面的
            dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[i + questions[i][1] + 1]);
        }
        return dp[0];
    }

    /*
        二分法:让n台电脑平均工作x分钟,电量大于下的电池最多只能提供x的电
              每个电池可以工作的最大时间是min(x,barriers[i]),将这些电池最大时间相加sum
              因此n*x<=sum即可
     */
    public long maxRunTime(int n, int[] batteries) {
        long total = 0;
        for (int battery : batteries) {
            total += battery;
        }
        long left = 0, right = total / n;//左右边界
        while (left <= right) {
            long sum = 0;
            long mid = left + (right - left) / 2;//这里也就是x
            for (int battery : batteries) {
                sum += Math.min(mid, battery);//也就是min(x,batteries[i]),每个电池的最大供应量
            }
            if (sum == n * mid) {//这里求最大值,右边界
                left = mid + 1;
            } else if (sum < n * mid) {//这里mid大了,right左移
                right = mid - 1;
            } else if (sum > n * mid) {
                left = mid + 1;
            }
        }
        return right;
    }
}
