package LeetCode.周赛.Game275;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> set1 = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!set1.add(matrix[i][j])) {
                    return false;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            Set<Integer> set1 = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!set1.add(matrix[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 输出窗口里面一共有多少个 "1"
     * 使用滑动窗口,以"1"的总数为窗口大小
     * 计算窗口中0的个数,找到含0最小的,即为最少交换次数
     *
     * @param nums 环形数组
     * @return size(窗口)-min(count0)
     */
    public int minSwaps(int[] nums) {
        int length = nums.length, nums1 = 0, res = Integer.MAX_VALUE;
        //统计1的个数
        for (int num : nums) {
            nums1 += num;
        }
        //窗口左边界为0,右边界为移动到nums1-1处,使得窗口大小为nums1,也就是含有1的总数
        int left = 0, right = 0, count1 = 0;
        while (right < nums1 - 1) {
            count1 += nums[right++];//窗口不断右移
        }

        //!由于是环形数组,所以窗口左边界一直移动到数组末尾才算循环结束
        while (left < length) {
            count1 += nums[right++ % length];//窗口右移取余
            res = Math.min(res, nums1 - count1);//比较所有窗口中距离所有1的最近数目
            count1 -= nums[left++];//窗口左移
        }
        return res;
    }

    /*
        T3:状态压缩
            1.startWords 必须追加非自身包含的字母-->枚举
            2.所有单词中的字母是唯一出现的-->判断是否唯一出现,二进制压缩每个单词(想象成bool数组)
            3.字母数量 26 个，全为小写-->枚举
     */
    public int wordCount(String[] startWords, String[] targetWords) {
        int res = 0;
        Set<Integer> set = new HashSet<>();

        //1.先把start的每个单词转换成二进制数字,并存储在set中
        for (String s : startWords) {
            int mask = 0;
            for (char ch : s.toCharArray()) {
                mask |= 1 << (ch - 'a');//将1左移对应字母的位数累计"或"
            }
            set.add(mask);//记录下来
        }
        //2.遍历target里面的单词
        for (String t : targetWords) {
            int mask = 0;
            for (char ch : t.toCharArray()) {
                mask |= 1 << (ch - 'a');//同上,求t的二进制数
            }
            //3.题目要求start必须加一个字母,也就是说target必须减少一个字母,然后比较set里面的二进制数字
            for (char ch : t.toCharArray()) {
                if (set.contains(mask ^ (1 << (ch - 'a')))) {//这里mask二进制位"^"异或第(1<<(ch-'a'))
                    res++;
                    break;
                }
            }
        }
        return res;
    }


    /*
        T4:权衡种花时间和成长时间,求让所有花结果的最短时间

        显然这里先种植长的慢的花即可

        种植时间是必不可少的,因此尽最大可能在成长时间内种植长的慢的话即可
     */
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int res = 0;
        int length = growTime.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((arr1, arr2) -> {
            return arr2[1] - arr1[1];
        });//优先队列,种植时间降序
        for (int i = 0; i < length; i++) {
            priorityQueue.offer(new int[]{plantTime[i], growTime[i]});
        }
        int growdays = 0;
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            growdays += poll[0];//种植时间
            res = Math.max(res, growdays + poll[1]);
        }
        return res;
    }
}
