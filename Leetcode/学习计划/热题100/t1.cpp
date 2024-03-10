#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  vector<int> twoSum(vector<int>& nums, int target) {
    unordered_map<int, int> ha;
    for (int i = 0; i < nums.size(); i++) {
      auto it = ha.find(target - nums[i]);
      if (it != ha.end()) {
        return {it->second, i};
      }
      ha[nums[i]] = i;
    }
    return {};
  }
};
class Solution2 {
 public:
  vector<int> twoSum(vector<int>& nums, int target) {
    for (int i = 0; i < nums.size() - 1; i++) {
      for (int j = i + 1; j < nums.size(); j++) {
        if (nums[i] + nums[j] == target) {
          return {i, j};
        }
      }
    }
    return {};
  }
};