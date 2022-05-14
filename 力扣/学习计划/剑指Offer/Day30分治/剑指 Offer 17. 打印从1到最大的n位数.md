#### [剑指 Offer 17. 打印从1到最大的n位数](https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/)

难度简单227

输入数字 `n`，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

**示例 1:**

```
输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
```

说明：

- 用返回一个整数列表来代替打印
- n 为正整数

#### 思路

> 不考虑大数问题,,直接模拟

#### Code

```java
public int[]printNumbers(int n){
        int[]res=new int[(int)(Math.pow(10,n)-1)];
        for(int i=0;i<res.length;i++){
        res[i]=i+1;
        }
        return res;
        }
```

#### 优化

> 考虑大数问题
>
> 字符串来代替int类型的+1操作
>
> 这里类似于n位里面的每一位全排列结果
>
> 先固定高位,然后顺序开启递归



![Picture1.png](https://pic.leetcode-cn.com/83f4b5930ddc1d42b05c724ea2950ee7f00427b11150c86b45bd88405f8c7c87-Picture1.png)

#### Code1

> 诸如 00, 01, 02, 00,01,02,⋯ 应显示为 0, 1, 2, 0,1,2,⋯ ，即应删除高位多余的 0 ;
> 此方法从 0 开始生成，而题目要求 列表从 1 开始 ；

```java
List<String> res=new ArrayList<>();
        StringBuffer sb=new StringBuffer();
        char[]num,loop={'1','2','3','4','5','6','7','8','9'};
        int n=0;

public List<String> printNumbers2(int n){
        this.n=n;
        num=new char[n];
        dfs(0);
        //res.remove(res.size() - 1);//去除多余的','
        return res;
        }

    /*
        由高到底固定每一位的数字,全排列
     */
private void dfs(int i){
        if(i==n){//当[0...n-1]全部固定好之后
        res.add(sb.toString());//加入答案
        return;
        }
        for(char c:loop){//遍历0..9位
        sb.append(c);//固定住第i位
        dfs(i+1);//开始第i+1位
        }
        }
        }
```

#### Code2

```java
   /**
 * 考虑大数问题(溢出)
 * 使用字符串输出,从高位向低位,凭借0-9 考虑首位0的情况
 */
    List<String> res=new ArrayList<>();
        StringBuffer sb=new StringBuffer();
        char[]loop={'1','2','3','4','5','6','7','8','9'};

public List<String> printNumbers2(int n){
        for(int i=1;i<=n;i++){
        dfs(0,i);//依次第0位,生成[1...n]位的数字
        }
        return res;
        }

/**
 * @param i   当前正在固定第i位
 * @param len 生成长度为len的数字
 *            当i=0,表示在最左边第1位,不能为0
 */
private void dfs(int i,int len){
        if(i==len){//当[0...n-1]全部固定好之后
        res.add(sb.toString());//加入答案
        return;
        }
        int start=i==0?1:0;//当i=0,表示左边第1位数字不能位0,直接从1开始
        for(int t=start;t<=9;t++){
        sb.append(t);//固定好当前位置
        dfs(t+1,len);//开始确认下一位数字
        sb.deleteCharAt(t);//回溯
        }
        }
        }
```