#include <bits/stdc++.h>
using namespace std;

class Solution {
 public:
  int returnToBoundaryCount(vector<int>& nums) {
    int n = nums.size();

    int position = 0;   // 蚂蚁的初始位置
    int crossings = 0;  // 到达边界的次数

    for (int i = 0; i < n; ++i) {
      if (nums[i] < 0) {
        position -= abs(nums[i]);  // 向左移动
      } else {
        position += abs(nums[i]);  // 向右移动
      }

      // 检查是否到达左右边界
      if (position == 0 ) {
        crossings++;
      }
    }

    return crossings;
  }
};