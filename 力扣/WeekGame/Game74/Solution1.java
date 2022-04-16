package 力扣.WeekGame.Game74;

public class Solution1 {
    public long maximumSubsequenceCount(String text, String pattern) {
        StringBuilder sb = new StringBuilder();
        char p0 = pattern.charAt(0);
        char p1 = pattern.charAt(1);
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == p0 || text.charAt(i) == p1) {
                sb.append(text.charAt(i));
            }
        }
        long l = sb.length();
        if (p0 == p1) {
            return (l + 1) * l / 2;
        }

        int firstNum = 0;
        int secondNum = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == p0) {
                firstNum++;
            } else {
                secondNum++;
            }
        }

        long origin = 0;
        long temp = secondNum;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == p0) {
                origin += temp;
            } else temp--;
        }
        long ans1 = origin + secondNum;
        long ans2 = origin + firstNum;
        return Math.max(ans1, ans2);
    }
}

