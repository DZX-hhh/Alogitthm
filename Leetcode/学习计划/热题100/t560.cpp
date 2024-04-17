#include <bits/stdc++.h>
using namespace std;

class Solution {
 public:
  // 超时
  int subarraySum_1(vector<int>& nums, int k) {
    int res = 0;
    for (int left = 0; left < nums.size(); left++) {
      int sum = 0;
      for (int right = left; right < nums.size(); right++) {
        sum += nums[right];
        if (sum == k) {
          res++;
        }
      }
    }
    return res;
  }

  int subarraySum_2(vector<int>& nums, int k) {
    int res = 0;
    vector<int> preSum(nums.size() + 1);  // 前缀和数组
    preSum[0] = 0;
    for (int i = 0; i < nums.size(); i++) {
      preSum[i + 1] = nums[i] + preSum[i];  // 构造前缀和
    }
    for (int left = 0; left < nums.size(); left++) {
      for (int right = left; right < nums.size(); right++) {
        if (preSum[right + 1] - preSum[left] == k) {
          res++;
        }
      }
    }
    return res;
  }

  int subarraySum_3(vector<int>& nums, int k) {
    int res = 0;
    unordered_map<int, int> preHash;  // key：前缀和，value：前缀和出现的次数
    preHash[0] = 1;                   // 前缀和为0的次数为1
    int presum = 0;                   // 初始前缀和
    for (int num : nums) {
      presum += num;
      res += preHash[presum - k];
      preHash[presum]++;
    }
    return res;
  }
};