#include <bits/stdc++.h>
using namespace std;

class Solution {
 public:
  bool isTriangle(int a, int b, int c) {  // 判读是否是三角形
    return a + b > c && b + c > a && a + c > b;
  }
  string triangleType(vector<int>& nums) {
    if (!isTriangle(nums[0], nums[1], nums[2])) {  // 不是三角形
      return "none";
    }
    // 如果一个三角形的所有边长度相等，那么这个三角形称
    if (nums[0] == nums[1] && nums[1] == nums[2]) {
      return "equilateral";
    }
    // 如果一个三角形恰好有两条边长度相等，那么这个三角形称为isosceles
    if (nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2]) {
      return "isosceles";
    }
    return "scalene";
  }
};