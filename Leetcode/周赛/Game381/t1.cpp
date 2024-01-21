#include <bits/stdc++.h>
using namespace std;

int main() { return 0; }

class Solution {
 public:
  int minimumPushes(string word) {
    if (word.size() <= 8) {
      return word.size();
    }
    if (word.size() <= 16) {
      return 8 + (word.size() - 8) * 2;
    }
    if (word.size() <= 24) {
      return 24 + (word.size() - 16) * 3;
    }

    return 48 + (word.size() - 24) * 4;
  }
};