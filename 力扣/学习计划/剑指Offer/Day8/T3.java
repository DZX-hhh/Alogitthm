package 力扣.学习计划.剑指Offer.Day8;

public class T3 {
    /*如果要盈利,,曲线必然是往上走的
    假设某一天的价格是最低的,那么就往后遍历,,维护一个最大值
    !!!当出现某一天价格更低,那么更新最低价格,,继续比较最大值
    */
    public int maxProfit(int[] prices) {
        int maxprofit = Integer.MIN_VALUE;
        int minprice = prices[0];
        for (int price : prices) {
            if (price < minprice) {
                minprice = price;
            } else if ((price - minprice) > maxprofit) {
                maxprofit = price - minprice;
            }
        }
        return maxprofit;
    }

    /*动态规划,,,也是维护最低价,,假设第i天前出售,,最大利润必然是当天的价钱-之前的最低价*/
    public int maxProfit2(int[] prices) {
        if (prices.length == 0) return 0;
        int maxprofit = 0;
        int[] dp = new int[prices.length];
        //dp[i]代表:第i天出售前的最低价,等于i-1天前的最低价和第i天的价格相比的更小值
        //dp[i]=Math.min(dp[i-1],prices[i])
        dp[0] = prices[0];
        for (int i = 1; i < dp.length; i++) {
            if (prices[i] < dp[i - 1]) {
                //说明prices[i]是当前最小值
                dp[i] = prices[i];
            } else {
                dp[i] = dp[i - 1];//说明当前最小值为前一个出售的最小值
                maxprofit = Math.max(maxprofit, prices[i] - dp[i]);
            }
        }
        return maxprofit;
    }
}
