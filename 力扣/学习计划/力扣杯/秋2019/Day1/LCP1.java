package 力扣.学习计划.力扣杯.秋2019.Day1;

public class LCP1 {
    //暴力法
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) count++;
        }
        return count;
    }
}
