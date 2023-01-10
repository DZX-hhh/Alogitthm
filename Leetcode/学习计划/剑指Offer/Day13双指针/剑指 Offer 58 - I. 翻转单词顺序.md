#### [剑指 Offer 58 - I. 翻转单词顺序](https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/)

难度简单202

输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

**示例 1：**

```
输入: "the sky is blue"
输出: "blue is sky the"
```

**示例 2：**

```
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
```

**示例 3：**

```
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
```

**说明：**

- 无空格字符构成一个单词。
- 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
- 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

**注意：**本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/

**注意：**此题对比原题有改动

* `split()`将n个空格认为1个空格,并分割
* `split("")`:遇见空字符串就跳过
* `split(" ")`以空格为分隔符,无法处理出现多个空格的情况

```java
    /*
        split()特点:如果连续两个分隔符在一块,那么会得到(前面结果,空,后面结果)
     */
public String reverseWords(String s){
        String[]split=s.trim().split(" ");//这里python里面split()默认多个空格为一个空格
        StringBuilder res=new StringBuilder();
        for(int i=split.length-1;i>=0;i--){
        if(split[i].equals("")){//遇到空字符就跳过,,因为split()特点:如果连续两个分隔符在一块,那么会得到(前面结果,空,后面结果)
        continue;
        }
        res.append(split[i]).append(" ");
        }
        return res.toString().trim();
        }
        }
```

**双指针**

```java
class Solution {
    /*
       双指针
    */
    public String reverseWords(String s) {
        char[] sArray = s.toCharArray();
        //1.先翻转整个字符串数组
        reverse(sArray, 0, s.length() - 1);
        //2.翻转每个单词
        reverseWord(sArray, s.length());
        //3.去除多余空格
        return cleanSpace(sArray, sArray.length);
    }

    /**
     * 翻转数组某个区间
     *
     * @param i 起始位置
     * @param j 结束位置
     */
    private void reverse(char[] sArray, int i, int j) {
        while (i < j) {
            char t = sArray[i];
            sArray[i++] = sArray[j];
            sArray[j--] = t;
        }
    }

    /**
     * 翻转数组的每个字母-->主要是找到
     */
    private void reverseWord(char[] sArray, int length) {
        int i = 0, j = 0;
        while (j < length) {
            //1.找到第一个首字母
            while (i < length && sArray[i] == ' ') {
                i++;
            }
            j = i;
            //2.找到末尾字母
            while (j < length && sArray[j] != ' ') {
                j++;
            }
            //3.开始翻转字母
            reverse(sArray, i, j - 1);
            //4.继续寻找下一个首字母
            i = j;
        }
    }

    /**
     * 去除多余空格
     */
    private String cleanSpace(char[] sArray, int length) {
        int i = 0, j = 0;
        while (j < length) {
            //1.跳过前置空格
            while (j < length && sArray[j] == ' ') {
                j++;
            }
            //2.找到非空格,即为单词,修改
            while (j < length && sArray[j] != ' ') {
                sArray[i++] = sArray[j++];
            }
            //3.单词记录结束,继续跳过空格
            while (j < length && sArray[j] == ' ') {
                j++;
            }
            //4.如果后面还有单词,就在当前位置加一个' '
            if (j < length) {
                sArray[i++] = ' ';
            }
        }
        //返回[0,i-1]的字符串
        return new String(sArray).substring(0, i);
    }
}
```

