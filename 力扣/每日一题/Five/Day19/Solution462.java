package 力扣.每日一题.Five.Day19;

import java.util.Arrays;

public class Solution462 {
    /*
        这里不能都变成平均值,实际上应该先排序+都变成中位数
        例如10086
        00168-->显然这里应该都变成1,而非5
     */
    public int minMoves2(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {//双指针前后遍历到中位数
            res += nums[right--] - nums[left++];//这里当left为1,right为3时,res=(1-0)+(6-1)=nums[right]-nums[left]
        }
        return res;
    }
}
