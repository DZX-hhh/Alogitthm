package Leetcode.Daily.Four7;

public class Solution {
    public boolean rotateString(String s, String goal) {
        //s+s已经可以确认所有的移动方案
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
