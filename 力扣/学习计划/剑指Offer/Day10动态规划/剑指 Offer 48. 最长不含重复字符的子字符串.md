#### [剑指 Offer 48. 最长不含重复字符的子字符串](https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)

难度中等420收藏分享切换为英文接收动态反馈

请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

**示例 1:**

```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

**示例 2:**

```
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

**示例 3:**

```
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

提示：

- `s.length <= 40000`

注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

**动态规划+哈希表**

```java
//动态规划
public int lengthOfLongestSubstring2(String s){

        Map<Character, Integer> map=new HashMap<>();
        int res=0,tempDp=0;
        for(int j=0;j<s.length();j++){
        int i=map.getOrDefault(s.charAt(j),-1);//获取`j`的上一个重复元素位置
        map.put(s.charAt(j),j);//更新哈希表,,字母j出现的位置

        //这里可以认为tempDp为dp[j]:  !!含义:以下标j结尾的字符,最大不重复的字串长度
        //1.如果当前j-i长度`>`dp[j-1],,那么意思就是  j固定,i超出了dp[j-1]长度的范围了,,那么dp[j-1]也有重复
        //`dp[j]=dp[j-1]+1`
        //2.如果当前j-i的长度`<`dp[j-1],那么意思就是  j固定,i在dp[j-1]长度的范围之内
        // 相比于dp[j-1],不出现重复的长度就是`j-i`
        //3.i为-1,未出现重复,,显然可以直接dp[j-1]+1
        tempDp=tempDp<j -i?tempDp+1:j-i;
        res=Math.max(res,tempDp);
        }
        return res;
        }
```