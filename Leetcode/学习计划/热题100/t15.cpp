#include <bits/stdc++.h>
using namespace std;

class Solution {
 public:
  vector<vector<int>> threeSum(vector<int>& nums) {
    vector<vector<int>> res;
    if (nums.size() < 3) {
      return res;
    }

    sort(nums.begin(), nums.end());
    for (int i = 0; i < nums.size() - 2; i++) {
      if (nums[i] > 0) {
        return res;
      }
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      int left = i + 1, right = nums.size() - 1;
      while (left < right) {
        if (nums[left] + nums[right] + nums[i] > 0) {
          right--;
        } else if (nums[left] + nums[right] + nums[i] < 0) {
          left++;
        } else {
          res.push_back({nums[i], nums[left], nums[right]});
          while (left < right && nums[left] == nums[left + 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }
          left++, right--;
        }
      }
    }
    return res;
  }
};