package 力扣.每日一题.Four.Four14;

public class Solution {
    public int maximumWealth(int[][] accounts) {
        int Max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            Max = Math.max(Max, sum);
        }
        return Max;
    }
}
