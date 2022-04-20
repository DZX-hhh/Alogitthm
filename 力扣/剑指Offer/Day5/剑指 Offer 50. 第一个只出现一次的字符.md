#### [剑指 Offer 50. 第一个只出现一次的字符](https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)

难度简单212收藏分享切换为英文接收动态反馈

在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

**示例 1:**

```
输入：s = "abaccdeff"
输出：'b'
```

**示例 2:**

```
输入：s = "" 
输出：' '
```

**限制：**

```
0 <= s 的长度 <= 50000
```

**哈希表`<Character,Integer>`**

```java
public char firstUniqChar(String s){
        Map<Character, Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
        map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c:s.toCharArray()){
        if(map.get(c)==1)return c;
        }
        return' ';
        }
```

**哈希表`<Character,Boolean>`**

```java
//对于哈希表里面已经存在的key,put()一个false,说明这个字符不只出现一次
public char firstUniqChar2(String s){
        Map<Character, Boolean> dic=new HashMap<>();

        char[]array=s.toCharArray();

        for(char c:array){
        dic.put(c,!dic.containsKey(c));
        }

        for(char c:array){
        if(dic.get(c))return c;
        }

        return' ';
        }
```

**计数数组**

```java
 public char firstUniqChar3(String s){
        //计数数组
        int[]count=new int[26];
        for(char c:s.toCharArray())count[c-'a']++;
        for(char c:s.toCharArray())if(count[c-'a']==1)return c;
        return' ';
        }
```

