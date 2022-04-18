package 力扣.每日一题.Four.Four9;

public class Solution {
    //反推法
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) return false;
        if (sx == tx && sy == ty || tx == sx && (ty - sy) % sx == 0 || ty == sy && (tx - sx) % sy == 0) return true;
        if (tx < ty) return reachingPoints(sx, sy, tx, ty % tx);
        else if (tx > ty) return reachingPoints(sx, sy, tx % ty, ty);
        return false;
    }
}
