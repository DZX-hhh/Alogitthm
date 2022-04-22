#### [剑指 Offer 63. 股票的最大利润](https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/)

难度中等239

假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

**示例 1:**

```
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
```

**示例 2:**

```
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
```

**限制：**

```
0 <= 数组长度 <= 10^5
```

**注意：**本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/

**正向模拟,维护最小值**

```java
/*如果要盈利,,曲线必然是往上走的
假设某一天的价格是最低的,那么就往后遍历,,维护一个最大值
!!!当出现某一天价格更低,那么更新最低价格,,继续比较最大值
*/
public int maxProfit(int[]prices){
        int maxprofit=Integer.MIN_VALUE;
        int minprice=prices[0];
        for(int price:prices){
        if(price<minprice){
        minprice=price;
        }else if((price-minprice)>maxprofit){
        maxprofit=price-minprice;
        }
        }
        return maxprofit;
        }
```

**动态规划**

```Java
/*动态规划,,,也是维护最低价,,假设第i天前出售,,最大利润必然是当天的价钱-之前的最低价*/
public int maxProfit2(int[]prices){
        if(prices.length==0)return 0;
        int maxprofit=0;
        int[]dp=new int[prices.length];
        //dp[i]代表:第i天出售前的最低价,等于i-1天前的最低价和第i天的价格相比的更小值
        //dp[i]=Math.min(dp[i-1],prices[i])
        dp[0]=prices[0];
        for(int i=1;i<dp.length;i++){
        if(prices[i]<dp[i-1]){
        //说明prices[i]是当前最小值
        dp[i]=prices[i];
        }else{
        dp[i]=dp[i-1];//说明当前最小值为前一个出售的最小值
        maxprofit=Math.max(maxprofit,prices[i]-dp[i]);
        }
        }
        return maxprofit;
        }
```