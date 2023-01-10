package LeetCode.学习计划.算法.Day12动态规划;

public class Solution45 {
    /*
        贪心: 维护当前覆盖范围以及下一步覆盖范围
              > 当下标到达当前覆盖范围
                     - 如果当前下标为数组末尾,直接返回步数
                     - 不是尾部,步数+1,更新当前覆盖范围为下一步覆盖范围
              > 当前下标没到达,continue
     */
    public int jump(int[] nums) {
        int step = 0;
        int nowDistance = 0, nextDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nextDistance, i + nums[i]);//更新下一步覆盖范围
            if (i == nowDistance) {//如果到达当前覆盖范围
                if (i != nums.length - 1) {//如果未到达终点,步数+1
                    step++;
                    nowDistance = nextDistance;//更新覆盖范围
                    if (nowDistance >= nums.length - 1) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return step;
    }

    /*
     * 改进版
     */
    public int jump2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int step = 0;
        int nowDistance = 0, nextDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nextDistance, i + nums[i]);//更新下一步最大范围
            if (nextDistance >= nums.length - 1) {//如果下一步覆盖范围,,可以直接到达数组末尾,,直接返回步数+1
                step++;
                break;
            }
            //如果到了当前覆盖范围的末尾,更新当前覆盖范围,步数+1
            if (i == nowDistance) {
                step++;
                nowDistance = nextDistance;
            }
        }
        return step;
    }

    /*
     * dp[0]当前最大覆盖范围
     * dp[1]下一个最大覆盖范围
     * dp[2]步数
     */
    public int jump3(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int[] dp = {0, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            dp[1] = Math.max(dp[1], i + nums[i]);//更新下一步最大范围
            if (dp[1] >= nums.length - 1) {//如果下一步覆盖范围,,可以直接到达数组末尾,,直接返回步数+1
                dp[2]++;
                break;
            }
            //如果到了当前覆盖范围的末尾,更新当前覆盖范围,步数+1
            if (i == dp[0]) {
                dp[2]++;
                dp[0] = dp[1];
            }
        }
        return dp[2];
    }
}
