package 力扣.每日一题.Four.Four26;

public class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int sumXY = 0, sumXZ = 0, sumYZ = 0;
        for (int i = 0; i < n; i++) {
            int maxXZ = 0, maxYZ = 0;
            for (int j = 0; j < n; j++) {
                sumXY += grid[i][j] > 0 ? 1 : 0;//如果没放物体,俯视就没有阴影
                maxXZ = Math.max(maxXZ, grid[i][j]);//每一行最大值,,保持X不变,让y递增,比较最大值
                maxYZ = Math.max(maxYZ, grid[j][i]);//每一列最大值,,保持Y不变,让x递增,比价最大值
            }
            sumXZ += maxXZ;
            sumYZ += maxYZ;
        }
        return sumXY + sumXZ + sumYZ;
    }
}
