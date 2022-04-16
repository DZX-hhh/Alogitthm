package 力扣.WeekGame.Game283;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public static String s = "K1:L2";

    public static List<String> cellsInRange(String s) {
        List<String> list = new ArrayList<>();
        char col1 = s.charAt(0);
        char row1 = s.charAt(1);
        for (char col = s.charAt(0); col <= s.charAt(3); col++) {
//            char row = s.charAt(1);
            for ( char row = s.charAt(1); row <= s.charAt(4); row++) {
                list.add(new String(new char[]{col, row}));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(cellsInRange(s));
//        cellsInRange(s);
    }
}
