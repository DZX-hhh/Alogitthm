#### [剑指 Offer 53 - I. 在排序数组中查找数字 I](https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)

难度简单298收藏分享切换为英文接收动态反馈

统计一个数字在排序数组中出现的次数。

**示例 1:**

```
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
```

**示例 2:**

```
输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
```

**提示：**

- `0 <= nums.length <= 105`
- `-109 <= nums[i] <= 109`
- `nums` 是一个非递减数组
- `-109 <= target <= 109`

**注意：**本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/

#### [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

难度中等1631收藏分享切换为英文接收动态反馈

给定一个按照升序排列的整数数组 `nums`，和一个目标值 `target`。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 `target`，返回 `[-1, -1]`。

**进阶：**

- 你可以设计并实现时间复杂度为 `O(log n)` 的算法解决此问题吗？

**示例 1：**

```
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
```

**示例 2：**

```
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
```

**示例 3：**

```
输入：nums = [], target = 0
输出：[-1,-1]
```

**提示：**

- `0 <= nums.length <= 105`
- `-109 <= nums[i] <= 109`
- `nums` 是一个非递减数组
- `-109 <= target <= 109`

**二分法**

> 时间复杂度:`lg(n)`

```java
//二分法
public int[]searchRange(int[]nums,int target){
        if(nums.length==0)return new int[]{-1,-1};
        //求左边界
        int start=startSearch(nums,target);
        //求右边界
        int end=endSearch(nums,target);
        return start>end?new int[]{-1,-1}:new int[]{start,end};
        }

//求左边界
private int startSearch(int[]nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
        int mid=left+(right-left)/2;
        if(nums[mid]>target){
        right=mid-1;
        }else if(nums[mid]<target){
        left=mid+1;
        }else{
        right=mid-1;
        }
        }
        return left;
        }

//求右边界
private int endSearch(int[]nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
        int mid=left+(right-left)/2;
        if(nums[mid]>target){
        right=mid-1;
        }else if(nums[mid]<target){
        left=mid+1;
        }else{
        left=mid+1;
        }
        }
        return right;
        }
```



