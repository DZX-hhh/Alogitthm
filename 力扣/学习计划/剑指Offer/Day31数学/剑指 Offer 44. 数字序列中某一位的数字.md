#### [剑指 Offer 44. 数字序列中某一位的数字](https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/)

难度中等250

数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

请写一个函数，求任意第n位对应的数字。

**示例 1：**

```
输入：n = 3
输出：3
```

**示例 2：**

```
输入：n = 11
输出：0
```

**限制：**

- `0 <= n < 2^31`

注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/

#### 思路

![image-20220516004150588](C:\Users\29608\AppData\Roaming\Typora\typora-user-images\image-20220516004150588.png)

![Picture1.png](https://pic.leetcode-cn.com/2cd7d8a6a881b697a43f153d6c10e0e991817d78f92b9201b6ab71e44cb619de-Picture1.png)

![image-20220516004659054](C:\Users\29608\AppData\Roaming\Typora\typora-user-images\image-20220516004659054.png)

![image-20220516004728150](C:\Users\29608\AppData\Roaming\Typora\typora-user-images\image-20220516004728150.png)

![image-20220516004745877](C:\Users\29608\AppData\Roaming\Typora\typora-user-images\image-20220516004745877.png)

##### Code(CV)

```java
public class Solution44 {
    /*
        CV
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}
```