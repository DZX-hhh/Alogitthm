#### [LCP 02. 分式化简](https://leetcode-cn.com/problems/deep-dark-fraction/)

难度简单96

有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/09/09/fraction_example_1.jpg)

连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。

输入的`cont`代表连分数的系数（`cont[0]`代表上图的`a0`，以此类推）。返回一个长度为2的数组`[n, m]`，使得连分数的值等于`n / m`，且`n, m`最大公约数为1。

**示例 1：**

```
输入：cont = [3, 2, 0, 2]
输出：[13, 4]
解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
```

**示例 2：**

```
输入：cont = [0, 0, 3]
输出：[3, 1]
解释：如果答案是整数，令分母为1即可。
```

**限制：**

1. `cont[i] >= 0`
2. `1 <= cont的长度 <= 10`
3. `cont`最后一个元素不等于0
4. 答案的`n, m`的取值都能被32位int整型存下（即不超过`2 ^ 31 - 1`）。

**暴力模拟**

```java
public class LCP02 {
    public int[] fraction(int[] cont) {
        //从后往前,初始化分子和分母
        int up = 1, down = 0;//初始化,使得最后一个元素时反转后为cont[i]
        for (int i = cont.length - 1; i >= 0; i--) {
            //每次相加之前,都需要进行分子分母的翻转
            int t = up;
            up = down;
            down = t;
            //翻转之后,分子叠加为(cont[i]*分母+分子)
            up = cont[i] * down + up;
        }
        return new int[]{up, down};
    }
}
```