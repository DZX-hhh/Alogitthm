package 力扣.周赛.华为;

public class T2 {
    /**
     * 注意到圆心坐标最大只有 100，半径最大也只有 100，那么我们可以枚举横纵坐标均小等于 200 的点
     * 再枚举每个圆检查是否有至少一个圆包含该点即可。
     */
    public int countLatticePoints(int[][] circles) {
        int count = 0;
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                for (int[] circle : circles) {
                    //计算距离
                    if ((circle[0] - i) * (circle[0] - i) + (circle[1] - j) * (circle[1] - j) <= circle[2]
                            * circle[2]) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}