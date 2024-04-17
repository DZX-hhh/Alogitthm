#include <bits/stdc++.h>
using namespace std;

class Solution {
 public:
  vector<int> maxSlidingWindow(vector<int>& nums, int k) {
    if (nums.size() == 0 || k == 0) {
      return vector<int>();
    }
    deque<int> deque;
    vector<int> res(nums.size() - k + 1);
    // 维护单调递减栈
    for (int i = 0; i < k; i++) {
      while (!deque.empty() && deque.back() < nums[i]) {
        deque.pop_back();
      }
      deque.push_back(nums[i]);
    }
    res[0] = deque.front();  // 单调递减栈的头部，也就是最大值
    for (int i = k; i < nums.size(); i++) {
      if (deque.front() == nums[i - k]) {  // 滑动窗口头部是否为最大值
        deque.pop_front();
      }
      while (!deque.empty() && deque.back() < nums[i]) {
        deque.pop_back();
      }
      deque.push_back(nums[i]);
      res[i - k + 1] = deque.front();  // 滑动窗口的最大值
    }
    return res;
  }
};