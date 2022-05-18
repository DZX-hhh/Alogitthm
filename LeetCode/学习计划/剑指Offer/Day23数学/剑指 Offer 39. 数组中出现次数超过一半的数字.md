#### [剑指 Offer 39. 数组中出现次数超过一半的数字](https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/)

难度简单280

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

**示例 1:**

```
输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
```

**限制：**

```
1 <= 数组长度 <= 50000
```

注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/

**排序**

```java
/*
    排序取中
 */
public int majorityElement(int[]nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
        }
```

**摩尔投票**

```java
 /*
        摩尔投票:极限一换一,当出现不同的将二者同归于尽,最后留下来的全是相同的
     */
public int majorityElement2(int[]nums){
        int res=0,count=0;//count为当前留下的计数
        for(int i=0;i<nums.length;i++){
        if(count==0){//无一幸存的情况下,新人上任
        res=nums[i];
        count++;
        }else{
        count=res==nums[i]?count+1:count-1;//同存异忘
        }
        }
        return res;
        }
        }
```