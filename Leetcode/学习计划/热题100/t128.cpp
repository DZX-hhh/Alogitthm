#include <bits/stdc++.h>
using namespace std;

class Solution {
 public:
  int longestConsecutive(vector<int>& nums) {
    unordered_set<int> se;
    for (int num : nums) {
      se.insert(num);
    }
    int res = 0;
    for (int num : se) {
      if (!se.count(num - 1)) {
        int currentNum = num;
        int currentRes = 1;
        while (se.count(currentNum + 1)) {
          currentRes += 1;
          currentNum += 1;
        }
        res = max(res, currentRes);
      }
    }
    return res;
  }
};