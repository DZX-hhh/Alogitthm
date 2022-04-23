package 力扣.周赛.Game282;

import java.util.HashMap;

public class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String s : words) {
            if (s.length() >= pref.length()) {
                if (s.startsWith(pref)) {
                    count++;
                }
            }

        }
        return count;
    }


    public int minSteps(String s, String t) {

        int temp = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : s.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for (char c : map1.keySet()) {
            if (!map2.containsKey(c)) {
                temp += map1.get(c);
            } else if (map2.get(c) < map1.get(c)) {
                temp += map1.get(c) - map2.get(c);
            }
        }
        for (char c : map2.keySet()) {
            if (!map1.containsKey(c)) {
                temp += map2.get(c);
            } else if (map1.get(c) < map2.get(c)) {
                temp += map2.get(c) - map1.get(c);
            }
        }
        return temp;
    }


    public long minimumTime2(int[] time, int totalTrips) {
        if (time.length == 1) {
            return (long) time[0] * totalTrips;
        }
        int[] total = new int[time.length];
        for (int t = 1; t < max(time) * totalTrips; t++) {
            for (int i = 0; i < time.length; i++) {
                total[i] = t / time[i];
            }
            if (sum(total) >= totalTrips) {
                return t;
            }
        }
        return time[0];
    }

    public long sum(int[] time) {
        long res = 0;
        for (int i : time) {
            res += i;
        }
        return res;
    }

    public long max(int[] time) {
        long max = Integer.MIN_VALUE;
        for (int i : time) {
            max = Math.max(i, max);
        }
        return max;
    }

    public long min(int[] time) {
        long min = Integer.MAX_VALUE;
        for (int i : time) {
            min = Math.max(i, min);
        }
        return min;
    }


    public long minimumTime(int[] time, int totalTrips) {
        long l = min(time) * totalTrips;
        long r = max(time) * totalTrips;
        while (l <= r) {
            long mid = 1 + (r - l) / 2;
            long t = 0;
            for (int i = 0; i < time.length; i++) {
                t += mid / time[i];
            }
            if (t < totalTrips) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
