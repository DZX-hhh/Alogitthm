package Leetcode.WeekGame.WeekGame75;

import java.util.*;

public class Solution {
    List<Integer> list = new LinkedList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    Deque<Integer> queue = new LinkedList<>();
    HashSet<Character> set = new HashSet<>();

    public int minBitFlips(int start, int goal) {
        int a = start ^ goal;
        return Integer.bitCount(a);
    }


    public int triangularSum2(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        text(nums, n - 1);
        return nums[0];
    }

    public void text(int[] nums, int len) {
        for (int i = 0; i < len; i++) {
            nums[i] = (nums[i] + nums[i + 1]) % 10;
        }
        if (len == 1) {
            return;
        }
        text(nums, --len);
    }


    public long numberOfWays(String s) {
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() / 2; j++) {
                for (int z = s.length() - 1; z >= s.length() / 2; z--) {

                }
            }
        }
        return sum;
    }

    //current = "02:30", correct = "04:35"
    public static int conv(String s) {
        String[] split = s.split(":");
        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        return min + hour * 60;
    }

    public static int convertTime(String current, String correct) {
        int now = conv(current);
        int target = conv(correct);
        int ans = 0;
        int de = target - now;
        if (de >= 60) {
            ans += de / 60;
            de %= 60;
        }
        if (de >= 15) {
            ans += de / 15;
            de %= 15;
        }
        if (de >= 5) {
            ans += de / 5;
            de %= 5;
        }
        if (de < 5) {
            ans += de;
        }
        return ans;
    }


    public static List<List<Integer>> findWinners(int[][] matches) {

        HashMap<Integer, Integer> lose = new HashMap<>();
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < matches.length; i++) {
            lose.put(matches[i][1], lose.getOrDefault(matches[i][1], 0) + 1);
        }
        for (int i = 0; i < matches.length; i++) {
            // System.out.println(matches[i][1]);
            if (!lose.containsKey(matches[i][0]) && !list1.contains(matches[i][0])) {
                list1.add(matches[i][0]);
                // System.out.println("queue" + queue1);
            }
            if (lose.get(matches[i][1]) == 1) {
                list2.add(matches[i][1]);
                // System.out.println("queue2" + queue2);
            }
        }

        //System.out.println(list1);
        //System.out.println(list2);
        Collections.sort(list1);
        Collections.sort(list2);
        List<List<Integer>> res = new LinkedList<>();
        res.add(list1);
        res.add(list2);
        return res;
    }


    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        findWinners(a);
    }
}
