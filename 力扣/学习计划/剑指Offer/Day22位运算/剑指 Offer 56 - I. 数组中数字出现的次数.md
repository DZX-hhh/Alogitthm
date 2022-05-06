#### [剑指 Offer 56 - I. 数组中数字出现的次数](https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/)

难度中等631收藏分享切换为英文接收动态反馈

一个整型数组 `nums` 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

**示例 1：**

```
输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
```

**示例 2：**

```
输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]
```

**限制：**

- `2 <= nums.length <= 10000`

**哈希表**

```java
/*
    哈希表
 */
public int[]singleNumbers(int[]nums){
        int[]res=new int[2];
        Map<Integer, Integer> map=new HashMap<>();
        for(int num:nums){
        map.put(num,map.getOrDefault(num,0)+1);
        }
        int index=0;
        for(int num:nums){
        if(map.get(num)==1)res[index++]=num;
        }
        return res;
        }
```

**位运算**

![image-20220506083734633](C:\Users\29608\AppData\Roaming\Typora\typora-user-images\image-20220506083734633.png)

```java
 /*
        位运算
           a^b^b^c^c^....^z
           =a^z
       由于题目中存在两个只出现一次的a,z
       那么a和z必然是不同的-->a,z必然至少存在一个二进制位不同-->a(m)^z(m)=1-->找到这个不同的位m-->找到m后分组将a&m和z&m
       也就是说:
       找到这个这个a,z不同的二进制位m,并将整个数组分为两个子数组
                                  每个子数组都各自分配一个出现一次的数字
     */
public int[]singleNumbers2(int[]nums){
        int m=1;//寻找a^z的第一个不同二进制位,左移
        int x=0,y=0,t=0;
        //1.得到a^z
        for(int num:nums){
        t^=num;
        }
        //2.开始找不同位m
        while((t^m)==0){
        m=m<<1;//m初始化为1,不断左移
        }
        //3.开始根据m分组,num&m-->第m位是否相同分组
        for(int num:nums){
        if((m&num)==1){
        x^=num;
        }else{
        y^=num;
        }
        }
        return new int[]{x,y};
        }
        }
```