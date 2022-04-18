package 力扣.力扣杯.春2022;

import java.util.Arrays;

class LCP50 {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] a : operations) {
            int from = a[0];
            int to = a[1];
            gem[to] += gem[from] / 2;
            gem[from] -= gem[from] / 2;
        }
        Arrays.sort(gem);
        return gem[gem.length - 1] - gem[0];
    }
}

class LCP51 {
    int maxAns = 0;

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        this.maxAns = -1;
        boolean[] exists = new boolean[cookbooks.length];
        //dfs回溯
        dfs(materials, cookbooks, attribute, exists, limit, 0, 0);
        return this.maxAns;
    }

    /**
     * @param matericals 表示第 j 种食材的数量。通过这些食材可以制作若干料理
     * @param cookbooks  表示制作第 i 种料理需要第 j 种食材的数量
     * @param attribute  第 i 道料理的美味度 x 和饱腹感 y
     * @param exists     是否做错
     * @param limit      最小饱腹感
     * @param sumx       美味感
     * @param sumy       饱腹感
     */
    public void dfs(int[] matericals, int[][] cookbooks, int[][] attribute, boolean[] exists, int limit, int sumx, int sumy) {
        if (sumy >= limit) this.maxAns = Math.max(maxAns, sumx);
        for (int i = 0; i < cookbooks.length; i++) {
            if (exists[i]) continue;

            int[] need = cookbooks[i];//当前这个菜的原料
            boolean canCook = true;//当前这个菜是否能做
            for (int j = 0; j < need.length; j++) {
                if (matericals[j] < need[j]) {//检查材料是否支持做这道菜
                    canCook = false;
                    break;
                }
            }
            //如果可以做,就尝试做
            if (canCook) {
                exists[i] = true;
                for (int j = 0; j < need.length; j++) {
                    matericals[j] -= need[j];//总材料减去成本
                }

                //接着尝试做下一道菜
                dfs(matericals, cookbooks, attribute, exists, limit, sumx + attribute[i][0], sumy + attribute[i][1]);

                //回溯

                for (int j = 0; j < need.length; j++) {
                    matericals[j] += need[j];//总材料减去成本
                }
                exists[i] = false;
            }
        }
    }
}
