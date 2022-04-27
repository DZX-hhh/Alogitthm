#### [剑指 Offer 57. 和为s的两个数字](https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/)

难度简单179

输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

**示例 1：**

```
输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
```

**示例 2：**

```
输入：nums = [10,26,30,31,47,60], target = 40
输出：[10,30] 或者 [30,10]
```

**限制：**

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^6`

**哈希表**

```java
public class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{nums[i], target - nums[i]};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
```

**对撞双指针**

```java
/*
    对撞双指针
 */
public int[] twoSum2(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
        if (nums[left] + nums[right] == target) {
            return new int[]{nums[left], nums[right]};
        } else if (nums[left] + nums[right] > target) {
            right--;
        } else if (nums[left] + nums[right] < target) {
            left++;
        }
    }
    return null;
}
```

**二分查找**

```java
 /*
        二分查找:先二分缩小范围,,再对撞双指针
     */
    public int[] twoSum3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //1.先二分缩小范围
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] + nums[mid] > target) {
                right = mid - 1;
            } else if (nums[right] + nums[mid] < target) {
                left = mid + 1;
            } else {
                break;
            }
        }
        if (left >= right) {
            return null;
        }
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            }
        }
        return null;
    }
}
```