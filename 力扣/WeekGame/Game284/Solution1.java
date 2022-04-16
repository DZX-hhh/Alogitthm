package 力扣.WeekGame.Game284;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == key && Math.abs(i - j) <= k) {
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }


    public static int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int count = 0;
        boolean[] f = new boolean[n * n];//标记
//        将要挖掘的地方设置为true,其他未挖掘的地方默认为false
        for (int[] d : dig) {
            int index = d[0] * n + d[1];//某行某列
            f[index] = true;
        }
        for (int[] art : artifacts) {
            boolean flag = true;//标记
            //各个元器件覆盖的范围
            for (int r = art[0]; r < art[2] && flag; r++) {
                for (int c = art[1]; c < art[3] && flag; c++) {
                    flag = f[r * n + c];//第r行第c列,如果是被挖掘的赋值为true,否则赋值为false,并且可以跳出循环
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    static int n = 2;
    static int[][] artifacts = {{0, 0, 0, 0}, {0, 1, 1, 1}};
    static int[][] dig = {{0, 0}, {0, 1}};

    public static void main(String[] args) {
        System.out.println(digArtifacts(n, artifacts, dig));
    }
}
