#### [剑指 Offer 16. 数值的整数次方](https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/)

难度中等300

实现 [pow(*x*, *n*)](https://www.cplusplus.com/reference/valarray/pow/) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。

**示例 1：**

```
输入：x = 2.00000, n = 10
输出：1024.00000
```

**示例 2：**

```
输入：x = 2.10000, n = 3
输出：9.26100
```

**示例 3：**

```
输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25
```

**提示：**

- `-100.0 < x < 100.0`
- `-231 <= n <= 231-1`
- `-104 <= xn <= 104`

注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/

**库函数**

```java
public double myPow(double x,int n){
        return Math.pow(x,n);
        }
```

**快速幂**

<img src="https://pic.leetcode-cn.com/379a042b9d8df3a96d1ac0f27346718033bf3bfce69731bab52bf6f372b4c8f4-Picture2.png" alt="Picture2.png" style="zoom:40%;" />

```java
public class Solution16 {
    /*
        快速幂
     */
    public double myPow2(double x, int n) {
        if (x == 0.0f) {
            return 0.0d;
        }
        long N = n;
        double res = 1.0;
        //将负数情况考虑
        if (n < 0) {
            N = -N;
            x = 1 / x;
        }
        //快速幂
        /*
        while (N > 0) {
            if (N % 2 == 0) {
                N /= 2;
                x *= x;
            } else {
                res *= x;
                N /= 2;
                x *= x;
            }
        }
        */
        //改进版  想象成分治法
        while (N > 0) {
            if ((N & 1) == 1) {// N & 1代表取出N的二进制最后一位
                res *= x;
            }
            N = N >> 1;//二进制右移等于除以2
            x *= x;//这里类似与
        }
        return res;
    }
}
```

