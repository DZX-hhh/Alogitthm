#### [剑指 Offer 61. 扑克牌中的顺子](https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/)

难度简单234收藏分享切换为英文接收动态反馈

从**若干副扑克牌**中随机抽 `5` 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

**示例 1:**

```
输入: [1,2,3,4,5]
输出: True
```

**示例 2:**

```
输入: [0,0,1,2,5]
输出: True
```

**限制：**

数组长度为 5

数组的数取值为 [0, 13] .

* **`HashSet`**记录是否重复
* 最大值-最小值(不包括0)是否小于5,因为如果超过5,说明不可能成顺子

```java
public class Solution61 {
    /*
        这里为顺子的条件:1.不存在重复  2.max-min<5,否则就超出范围了,就算有大小王无法弥补顺子
     */
    public boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (!set.add(num)) {//出现重复,返回false(大小王例外)
                return false;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min < 5;
    }
```

**`直接排序`**

```java
//最小值为除去王的值,最大值为nums[4]
public boolean isStraight2(int[]nums){
        Arrays.sort(nums);
        int jokerNums=nums[0]==0?1:0;
        for(int i=1;i<nums.length;i++){
        if(nums[i]==0){
        jokerNums++;
        continue;
        }
        if(nums[i]==nums[i-1]){
        return false;
        }
        }
        return nums[4]-nums[jokerNums]< 5;
        }
        }
```