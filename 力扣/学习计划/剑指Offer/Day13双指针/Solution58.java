package 力扣.学习计划.剑指Offer.Day13双指针;

public class Solution58 {
    /*
        split()特点:如果连续两个分隔符在一块,那么会得到(前面结果,空,后面结果)
     */
    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");//这里python里面split()默认多个空格为一个空格
        StringBuilder res = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].equals("")) {//遇到空字符就跳过,,因为split()特点:如果连续两个分隔符在一块,那么会得到(前面结果,空,后面结果)
                continue;
            }
            res.append(split[i]).append(" ");
        }
        return res.toString().trim();
    }
}
