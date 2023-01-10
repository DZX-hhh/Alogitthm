package LeetCode.学习计划.算法.Day16动态规划;

import java.util.Arrays;

public class Solution300 {
    /*
        子序列未必连续
        dp[i]:以nums[i]结尾的最长序列的长度
        dp[i]=max(dp[j],dp[j]+1)//在[0,i-1]中
        如果nums[i]>nums[j],那么num[i]可以接在nums[j]后面,维持递增序列dp[i]=dp[j]+1
        这里比最大,枚举[0,i-1]的j,取最大值
     */
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);//每个子串都可以单独成一个序列
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {//nums[i]可以接在nums[j]后面dp[i]=dp[j]+1,这里比较出最大值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //每次比较完之后,需要再次比较出最大值,因为不同nums[i]结尾,长度可能不同
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /*
        优化:动态规划+二分法
        由于每一个dp[i]都需要比较num[i]和num[j]
        这里直接考虑维护一个尾部数组tail[i]:长度为i+1时,子序列的尾部元素,保存最长上升子序列
        遍历数组,当num[i]<当前元素,用num[i]替代当前位置的元素
                当num[i]>当前元素,用再当前元素后面接上nums[i]-->tail[++idx]=num[i]
                因此这里需要二分找到num[i]应该插入的位置-->比nums[i]大的最小元素,求左边界
     */
    public int lengthOfLIS2(int[] nums) {
        int maxLength = 0;
        int[] tail = new int[nums.length];
        for (int num : nums) {
            //1.num>tail[maxLength]:表示num已经是最大,因此将num加入到tail[]末尾
            //2.tail[i-1]<num<=tail[i],更新相应的tail[i],插在tail[i-1]后面,替换tail[i]
            int left = 0, right = maxLength;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (tail[mid] == num) {
                    right = mid - 1;
                } else if (tail[mid] > num) {
                    right = mid - 1;
                } else if (tail[mid] < num) {
                    left = mid + 1;
                }
            }
            tail[left] = num;//更新答案,插入num
            if (left == maxLength) {
                //如果恰好是最后一个,那么maxLength+1
                maxLength++;
            }
        }
        return maxLength;
    }
}
