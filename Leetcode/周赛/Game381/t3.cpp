#include <bits/stdc++.h>
using namespace std;

class Solution {
 public:
  int minimumPushes(string word) {  // word里面存在重复字母
    int res = 0;

    vector<int> V(26, 0);
    for (char ch : word) {
      V[ch - '0']++;
    }
    sort(V.begin(), V.end());

    for (int i = 0; i < 8; i++) {
      res += V[i];
    }

    for (int i = 8; i < 16; i++) {
      res += V[i] * 2;
    }

    for (int i = 16; i < 24; i++) {
      res += V[i] * 3;
    }

    for (int i = 24; i < 26; i++) {
      res += V[i] * 4;
    }

    return res;
  }
};