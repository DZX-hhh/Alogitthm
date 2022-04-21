package 力扣.每日一题.Four.Four21;

public class Solution {
    //字符拼接,,通过last+="a"的解决字符串
    public String toGoatLatin(String sentence) {
        String aeiou = "aeiouAEIOU";
        StringBuffer res = new StringBuffer();
        String last = "a";
        for (String s : sentence.split(" ")) {
            if (aeiou.indexOf(s.charAt(0)) >= 0) {
                res.append(s).append("ma").append(last).append(" ");
            } else {
                res.append(s.substring(1)).append(s.charAt(0)).append("ma").append(last).append(" ");
            }
            last += "a";
        }
        return res.toString().trim();
    }
}
