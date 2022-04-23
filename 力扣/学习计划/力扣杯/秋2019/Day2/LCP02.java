package 力扣.学习计划.力扣杯.秋2019.Day2;

public class LCP02 {
    public int[] fraction(int[] cont) {
        //从后往前,初始化分子和分母
        int up = 1, down = 0;//初始化,使得最后一个元素时反转后为cont[i]
        for (int i = cont.length - 1; i >= 0; i--) {
            //每次相加之前,都需要进行分子分母的翻转
            int t = up;
            up = down;
            down = t;
            //翻转之后,分子叠加为(cont[i]*分母+分子)
            up = cont[i] * down + up;
        }
        return new int[]{up, down};
    }
}
