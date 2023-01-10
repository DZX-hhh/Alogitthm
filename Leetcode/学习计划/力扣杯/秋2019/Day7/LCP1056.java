package LeetCode.学习计划.力扣杯.秋2019.Day7;

import java.util.HashMap;
import java.util.Map;

public class LCP1056 {
    public boolean confusingNumber(int N) {
        Map<String, String> a = new HashMap(5);
        a.put("0", "0");
        a.put("1", "1");
        a.put("6", "9");
        a.put("8", "8");
        a.put("9", "6");
        String s = String.valueOf(N);
        StringBuffer reverseStr = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (!a.containsKey(String.valueOf(c))) {
                return false;
            }
            reverseStr.append(a.get(String.valueOf(c)));
        }
        return !s.equals(reverseStr.reverse().toString());
    }
}
