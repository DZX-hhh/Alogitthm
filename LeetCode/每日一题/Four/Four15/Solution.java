package LeetCode.每日一题.Four.Four15;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    int INF = 1000010;

    public NestedInteger deserialize(String s) {
        //栈
        Deque<NestedInteger> d = new ArrayDeque<>();
        char[] cs = s.toCharArray();
        int n = cs.length, i = 0;
        while (i < n) {
            //遇到','就跳过
            if (cs[i] == ',' && ++i >= 0) continue;
            //是'-'或者'数字':将连续数值的字符取出,创建数值形NestedInteger,压栈
            if (cs[i] == '-' || (cs[i] >= '0' && cs[i] <= '9')) {
                int j = i + 1;
                while (j < n && (cs[j] >= '0' && cs[j] <= '9')) j++;
                d.addLast(new NestedInteger(Integer.parseInt(s.substring(i, j))));
                i = j;
            }
            //'['创建嵌套类型的NeInteger并压栈,同时压入一个标识作用的的NeInteger对象
            else if (cs[i] == '[') {
                d.addLast(new NestedInteger());
                d.addLast(new NestedInteger(INF));
                i++;
            }
            //']'从栈中取出元素,直到遇见 [标识] 作用NeInteger对象,说明找到与当前匹配的'['
            else {
                List<NestedInteger> list = new ArrayList<>();
                while (!d.isEmpty()) {
                    NestedInteger poll = d.pollLast();
                    if (poll.isInteger() && poll.getInteger() == INF) break;
                    list.add(poll);
                }
                for (int j = list.size() - 1; j >= 0; j--) d.peekLast().add(list.get(j));
                i++;
            }
        }
        return d.peekLast();
    }

}

class NestedInteger {
    // Constructor initializes an empty nested list.


    public NestedInteger() {

    }

    // Constructor initializes a single integer.


    public NestedInteger(int value) {

    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.


    public boolean isInteger() {
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list


    public Integer getInteger() {
        return 0;
    }

    // Set this NestedInteger to hold a single integer.


    public void setInteger(int value) {

    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.


    public void add(NestedInteger ni) {

    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer


    public List<NestedInteger> getList() {
        return new ArrayList<>();
    }

}
