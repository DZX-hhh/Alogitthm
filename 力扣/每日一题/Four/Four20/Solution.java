package 力扣.每日一题.Four.Four20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthLongestPath(String input) {
        //k-层级   v-字符串
        Map<Integer, String> map = new HashMap<>();
        int n = input.length();
        String res = null;
        /*先检查在开头的'\t'  后检查在末尾的'\n'*/
        for (int i = 0; i < n; ) {
            int level = 0;
            //计算层级
            while (i < n && input.charAt(i) == '\t' && ++level >= 0) {
                i++;
            }
            //当前层数level,路径归属到level-1(上一层)
            int j = i;
            boolean isDir = true;
            while (j < n && input.charAt(j) != '\n') {
                if (input.charAt(j++) == '.') {
                    isDir = false;//如果是.txt那就说明是文件而不是目录,文件名归属到上一级
                }
            }
            String curr = input.substring(i, j);//文件长度
            String prev = map.getOrDefault(level - 1, null);//上一层的路径
            String path = prev == null ? curr : prev + "/" + curr;
            //如果是目录路径,那么就更新当前的目录路径
            if (isDir) {
                map.put(level, path);
            } else if (res == null || path.length() > res.length()) {//如果是文件并且长度更大
                res = path;
            }
            i = j + 1;//j指针已经跳到'\n'了,因此i=j+1,而不是i++,,开始下一个循环
        }
        return res == null ? 0 : res.length();
    }


    /**
     * 相比于前者,这里不记录字符串具体路径,,直接记录某一层的长度
     */
    static int[] hash = new int[10010];//记录某一层的路径长度

    public int lengthLongestPath2(String s) {
        Arrays.fill(hash, -1);
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; ) {
            int level = 0;
            while (i < n && s.charAt(i) == '\t' && ++level >= 0) i++;
            int j = i;
            boolean isDir = true;
            while (j < n && s.charAt(j) != '\n') {
                if (s.charAt(j++) == '.') isDir = false;
            }
            int currLen = j - i;//这里不截取,直接记录长度
            int prev = level - 1 >= 0 ? hash[level - 1] : -1;//如果有上一层,就取出上一层长度
            int path = prev + 1 + currLen;//计算路径,,中间的+1+其实也就是+'/'+
            if (isDir) hash[level] = path;
            else if (path > ans) ans = path;
            i = j + 1;
        }
        return ans;
    }
}

