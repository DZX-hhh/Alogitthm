#include <bits/stdc++.h>
using namespace std;

class Solution {
 public:
  vector<int> countOfPairs(int n, int x, int y) {
    vector<int> result(n, 0);

    for (int i = 1; i <= n; ++i) {
      for (int j = i + 1; j <= n; ++j) {
        int distance = min({abs(j - i), abs(x - i) + 1 + abs(y - j),
                            abs(y - i) + 1 + abs(x - j)});

        ++result[distance - 1];
      }
    }
    for (int i = 0; i < result.size(); i++) {
      result[i] *= 2;
    }
    return result;
  }
};