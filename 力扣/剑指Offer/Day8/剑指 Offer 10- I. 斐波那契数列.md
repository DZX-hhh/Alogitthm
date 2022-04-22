#### [剑指 Offer 10- I. 斐波那契数列](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/)

难度简单345

写一个函数，输入 `n` ，求斐波那契（Fibonacci）数列的第 `n` 项（即 `F(N)`）。斐波那契数列的定义如下：

```
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
```

斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

**示例 1：**

```
输入：n = 2
输出：1
```

**示例 2：**

```
输入：n = 5
输出：5
```

**提示：**

- `0 <= n <= 100`

**直接递归** :超时,因为有太多重复计算量

```java
public class T1 {
    /*直接使用递归,,超时,,重复计算量过多*/
    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
```

**维护备忘录`FIB[]`**

```java
/*解决重复计算的问题,,使用一个数组作为备忘录,,计算了结果,那么就直接使用这个结果,而不需要再递归计算,*/
int FIB[]=new int[101];

public int fib2(int n){
        if(n<=1)return n;
        if(FIB[n]!=0){
        //数组默认为0,,当不为0的说明已经计算过,,可以直接使用
        return FIB[n];
        }
        return FIB[n]=(int)((fib(n-1)+fib(n-2))%(1e9+7));
        }
```

**动态规划**

```java
/*动态规划,,也是维护一个备忘录数组,,知道后面返回[n]即可*/
public int fib3(int n){
        int mod=1000000007;
        if(n<=1)return n;
        int[]dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
        dp[i]=(dp[i-1]+dp[i-2])%mod;
        }
        return dp[n];
        }
```