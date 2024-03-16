#include <bits/stdc++.h>
using namespace std;

class Solution {
 public:
  int lengthOfLongestSubstring(string s) {
    unordered_map<char, int> dic;
    int left = -1, res = 0, n = s.size();
    for (int right = 0; right < n; right++) {
      if (dic.find(s[right]) != dic.end()) {
        left = max(left, dic.find(s[right])->second);
      }
      dic[s[right]] = right;
      res = max(res, right - left);
    }
    return res;
  }
};