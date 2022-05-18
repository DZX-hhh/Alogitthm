package LeetCode.周赛.招银;


public class Solution {
    public String deleteText(String article, int index) {
        if (article.charAt(index) == ' ') {
            return article;
        }
        int left = index;
        int right = index;
        while (left > 0) {
            if (article.charAt(left) == ' ') {
                break;
            }
            left--;
        }
        while (right < article.length()) {
            if (article.charAt(right) == ' ') {
                break;
            }
            right++;
        }
        if (left == 0) {
            if (right == article.length()) {
                return "";
            }
            return article.substring(right + 1);
        }
        return article.substring(0, left) + article.substring(right);
    }


    public int numFlowers(int[][] roads) {
        int[] deg = new int[roads.length + 1];
        int max = 0;
        //记录每个花坛的临界点个数
        for (int[] arr : roads) {
            deg[arr[0]]++;
            deg[arr[1]]++;
        }
        //找到临界点最多的花坛
        for (int i : deg) max = Math.max(max, i);
        //返回中间一个最多次数的+其他不同由于这个颜色的临界点个数
        return max + 1;
    }

}



