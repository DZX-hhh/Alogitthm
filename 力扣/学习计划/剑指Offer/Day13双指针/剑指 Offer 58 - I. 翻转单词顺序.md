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