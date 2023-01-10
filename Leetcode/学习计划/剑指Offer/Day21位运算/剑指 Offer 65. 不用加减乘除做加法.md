#### [剑指 Offer 65. 不用加减乘除做加法](https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/)

难度简单309收藏分享切换为英文接收动态反馈

写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

**示例:**

```
输入: a = 1, b = 1
输出: 2
```

**提示：**

- `a`, `b` 均可能是负数或 0
- 结果不会溢出 32 位整数

![image-20220505210249888](C:\Users\29608\AppData\Roaming\Typora\typora-user-images\image-20220505210249888.png)

**公式**

![image-20220505211847488](C:\Users\29608\AppData\Roaming\Typora\typora-user-images\image-20220505211847488.png)

<img src="https://pic.leetcode-cn.com/56d56524d8d2b1318f78e209fffe0e266f97631178f6bfd627db85fcd2503205-Picture1.png" alt="Picture1.png" style="zoom: 50%;" />

```java
public class Solution65 {
    public int add(int a, int b) {
        while (b != 0) {//当b为0,,说明进位为0,加法结束
            int c = (a & b) << 1;//& 进位:向左移一位
            a ^= b;//^ 无进位加法
            b = c;//更新b为进位
        }
        return a;
    }
}
```

