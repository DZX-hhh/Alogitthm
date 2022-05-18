package LeetCode.学习计划.算法.Day17动态规划;

public class Solution718 {
    //dp[i][j]:以下标i-1为结尾的A,以下标j-1为结尾的B,最长重复子数组的长度dp[i][j]
    //dp[0][0]不合法,因此i,j从1开始
    //dp[i][j]=dp[i-1][j-1]+1
    public int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {//出现公共重复元素
                    dp[i][j] = dp[i - 1][j - 1] + 1;//长度+1
                }
                if (dp[i][j] > res) {
                    res = dp[i][j];//更新最大长度
                }
            }
        }
        return res;
    }
}
