#### [剑指 Offer 21. 调整数组顺序使奇数位于偶数前面](https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/)

难度简单222

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。

**示例：**

```
输入：nums = [1,2,3,4]
输出：[1,3,2,4] 
注：[3,1,2,4] 也是正确的答案之一。
```

**提示：**

1. `0 <= nums.length <= 50000`
2. `0 <= nums[i] <= 10000`

**前后指针**

```java
public class Solution21 {
    public int[] exchange(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {//奇数偶数未必个数相等
            if (nums[left] % 2 == 1) {//如果前半部分为奇数,继续
                left++;
            } else {//出现偶数
                while (right > left && nums[right] % 2 == 0) {
                    right--;//找到右半部分奇数
                }
                if (right <= left) {//如果已经到达边界,直接返回
                    return nums;
                }
                if (nums[right] % 2 == 1) {//后半部分出现奇数,,那么就让  前半部分出现的偶数 与 后半部分出现的奇数  交换位置
                    int t = nums[left];
                    nums[left] = nums[right];
                    nums[right] = t;
                    right--;
                }
            }
        }
        return nums;
    }
}
```