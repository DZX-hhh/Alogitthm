package 力扣.力扣杯.秋2019.Day1;

public class LCP3 {
    /**
     * 1:先判断能否到达终点
     * 2:在到达重点钱是否到达陷阱,若能则返回false
     * 3:判断时取模优化
     * 4:第一轮机器人坐标(0,0)->(fx,fy),,记录一轮下来坐标总体发生的变化
     * 5:若能到达(tx,ty),必然满足tx=k*fx+x0,,,,,ty=k*fy+yo
     * 6:其中k=min(tx/fx,ty/fy)
     *
     * @param command   无限循环命令
     * @param obstacles 陷阱
     * @param tx        目标横坐标x
     * @param ty        目标纵坐标
     * @return
     */
    public boolean robot(String command, int[][] obstacles, int tx, int ty) {
        int n = command.length();
        int sx = 0, sy = 0;
        //记录走完一轮机器人的位置
        for (int i = 0; i < n; i++) {
            char c = command.charAt(i);
            if (c == 'U') ++sy;
            else ++sx;
        }

        //先计算能否达到重点,不考虑障碍物
        boolean canFinish = canReach(command, tx, ty, sx, sy);
        if (!canFinish) return false;
        //如果能在不考虑陷阱的情况下到达重点,那么就开始检查到达终点前能否到达陷阱,反之返回false
        for (int[] a : obstacles) {
            if (a[0] > tx || a[1] > ty) {//陷阱超过终点,不会爆炸
                continue;
            }
            if (canReach(command, a[0], a[1], sx, sy)) return false;
        }
        return true;
    }

    /*
    这里fx表示一轮下来,x的变化量
    判断是否能从(sx,sy)->(tx,ty)
    */
    private boolean canReach(String command, int tx, int ty, int fx, int fy) {
        //至少走这么多轮,在这之后必然有一个坐标等于目标值,这是唯一机会
        int loops = Math.min(tx / fx, ty / fy);
        int nowX = loops * fx, nowY = loops * fy;
        if (nowX == tx && nowY == ty) return true;
        int len = command.length();
        for (int i = 0; i < len; i++) {
            char c = command.charAt(i);
            if (c == 'U') ++nowY;
            else ++nowX;
            if (nowX > tx || nowY > ty) return false;
            if (nowX == tx && nowY == ty) return true;
        }
        return true;
    }
}
