package 力扣.学习计划.力扣杯.秋2021;

public class LCP39 {
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int m = source.length, n = source[0].length, res = 0;
        int count[] = new int[10005];
        for (int i = 0; i < m * n; i++) {
            //i/n代表在第几行
            //i%n代表在第几列

            //当source[r][c]出现,,计数+1
            count[source[i / n][i % n]]++;
            //当target[r][c]出翔,,计数-1,
            //如果目标值与本来的不需要变颜色,那+的个数和-的个数抵消
            //如果需要变颜色,那么-的那个元素  就对应着  本应该-的source的元素
            //那么后面只需要返回正数即可
            count[target[i / n][i % n]]--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) res += count[i];
        }
        return res;
    }
}
