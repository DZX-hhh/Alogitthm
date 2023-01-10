package LeetCode.学习计划.算法.Day20其他;

import java.util.HashMap;

public class Solution149 {
    /*
        枚举两个点,看其他的点是否在一条线上,需要第三次循环找点
        比较出最大值
     */
    public int maxPoints(int[][] points) {
        int res = 1;
        for (int i = 0; i < points.length; i++) {//选取两个点
            int[] point1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                int count = 2;
                for (int k = j + 1; k < points.length; k++) {//枚举第三个点
                    int[] point3 = points[k];
                    int dt1 = (point3[1] - point1[1]) * (point2[0] - point1[0]);
                    int dt2 = (point2[1] - point1[1]) * (point3[0] - point1[0]);
                    count += dt1 == dt2 ? 1 : 0;//如果是在线上,更新答案
                }
                res = Math.max(count, res);
            }
        }
        return res;
    }

    /*
        哈希表:优化
        这里哈希表记录从i点出发的直线所经过的最多点数量
        在第二次循环将斜率一样的点j记录下来
        考虑到1/2和2/4精度的问题,使用gcd求最大公约数
        并保存好map
     */
    public int maxPoints2(int[][] points) {
        int res = 1;
        for (int i = 0; i < points.length; i++) {
            //这里哈希表记录从点`i`出发的直线所经过的最多点数量
            HashMap<String, Integer> map = new HashMap<>();
            int max = 0;
            for (int j = i + 1; j < points.length; j++) {//这里枚举所有点
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int dtx = x2 - x1, dty = y2 - y1;
                int k = gcd(dtx, dty);
                String key = (dtx / k) + "_" + (dty / k);//这里记录斜率,存在精度问题,不直接算出来
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));//比较起点i的数目最大值
            }
            res = Math.max(res, max + 1);//比较所有起点的最大值
        }
        return res;
    }

    /**
     * 最大公约数的递归：
     * 1、若a可以整除b，则最大公约数是b
     * 2、如果1不成立，最大公约数便是b与a%b的最大公约数
     * 示例：求(140,21)
     * 140%21 = 14
     * 21%14 = 7
     * 14%7 = 0
     * 返回7
     *
     * @param dtx
     * @param dty
     * @return dty 求最大公约数
     */
    private int gcd(int dtx, int dty) {
        return dty == 0 ? dtx : gcd(dty, dtx % dty);
    }
}
