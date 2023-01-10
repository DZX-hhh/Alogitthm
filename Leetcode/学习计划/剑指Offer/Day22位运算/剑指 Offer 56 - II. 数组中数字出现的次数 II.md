#### [剑指 Offer 56 - II. 数组中数字出现的次数 II](https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/)

难度中等337收藏分享切换为英文接收动态反馈

在一个数组 `nums` 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

**示例 1：**

```
输入：nums = [3,4,3,3]
输出：4
```

**示例 2：**

```
输入：nums = [9,1,7,9,7,9,7]
输出：1
```

**限制：**

- `1 <= nums.length <= 10000`
- `1 <= nums[i] < 2^31`

**哈希表**

```java
HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
        int times=map.get(nums[i])!=null?map.get(nums[i]):0;
        map.put(nums[i],times+1);
        }
        // 难点是HashMap中通过value获取key

        //方法一： 用keySet，for遍历
        for(int key:map.keySet()){
        if(map.get(key)==1){
        return key;
        }
        }
        return nums[0];
```

**遍历统计**

对所有二进制位数 取和后`%3`

> 实际上，只需要修改求余数值 *m*
>
> 即可实现解决 **除了一个数字以外，其余数字都出现 m次**的通用问题。

![Picture1.png](https://pic.leetcode-cn.com/28f2379be5beccb877c8f1586d8673a256594e0fc45422b03773b8d4c8418825-Picture1.png)

```java
 /*
        遍历统计各个二进制位次数
        取余m(m为其他重复的次数)
        然后res从0(左移,或上(第31-i位取余m) )
     */
public int singleNumber2(int[]nums){
        int[]count=new int[32];//这里为32位二进制各个位的个数
        for(int i=0;i<nums.length;i++){
        for(int j=0;j< 32;j++){
        count[j]+=nums[i]&1;//将nums[i]的最后一位1取出来,放到计数数组
        nums[i]>>>=1;//无符号右移,这里取出32位来
        }
        }
        //这里将统计的二进制计数
        int res=0,m=3;
        for(int i=0;i< 32;i++){
        res=res<<1;//左移一位
        res|=count[31-i]%m;//将各个二进制%m后恢复到数字res中
        }
        return res;
        }
        }
```
