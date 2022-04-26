package 力扣.学习计划.算法.Day4双指针;

public class Solution11 {
    /*
        前后指针+贪心
        由于`area=min(height[left],height[eight])*(right-left)`
        并且 如果移动更大的指针,,也不能将更小值变大,并且距离在减小
        所以不断移动更小指针,维护答案的最大值
     */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
