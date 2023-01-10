package LeetCode.每日一题.Five.Day15;

public class Solution812 {
    /*
        海伦公式
        求最大三角形面积,三条边为a,b,c
        s=sqrt(p*(p-a)*(p-b)*(p-c))
        p=(a+b+c)/2
     */
    public double largestTriangleArea(int[][] points) {
        double res = 0;
        int length = points.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    //求三角形三条边的长度
                    double a = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                    double b = Math.sqrt(Math.pow(points[j][0] - points[k][0], 2) + Math.pow(points[j][1] - points[k][1], 2));
                    double c = Math.sqrt(Math.pow(points[i][0] - points[k][0], 2) + Math.pow(points[i][1] - points[k][1], 2));
                    //海伦公式
                    double p = (a + b + c) / 2.0;
                    //这里double精度的问题,会出现NaN的情况,需要判断是否为数字,跳过isNaN的情况
                    double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                    if (Double.isNaN(area)) {
                        continue;
                    }
                    //比较最大面积
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    /*
        鞋带公式
        a=x1y2+x2y3+x3y1
        b=x2y1+x3y2+x1y3
        area=abs(a-b)/2
     */
    public double largestTriangleArea2(int[][] points) {
        double res = 0;
        int length = points.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    int[] pointi = points[i];
                    int[] pointj = points[j];
                    int[] pointk = points[k];
                    int x1 = pointi[0], y1 = pointi[1];
                    int x2 = pointj[0], y2 = pointj[1];
                    int x3 = pointk[0], y3 = pointk[1];
                    double a = x1 * y2 + x2 * y3 + x3 * y1;
                    double b = x2 * y1 + x3 * y2 + x1 * y3;
                    res = Math.max(res, Math.abs((a - b) * 0.5));
                }
            }
        }
        return res;
    }
}
