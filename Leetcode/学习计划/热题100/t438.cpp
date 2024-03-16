#include <bits/stdc++.h>
using namespace std;

class Solution {
 public:
  vector<int> findAnagrams(string s, string p) {
    vector<int> res;
    vector<int> pcount(26), scount(26);
    int n1 = s.size(), n2 = p.size();
    if (n1 < n2) {
      return vector<int>();
    }

    for (int i = 0; i < n2; i++) {
      ++scount[s[i] - 'a'];
      ++pcount[p[i] - 'a'];
    }
    if (pcount == scount) {
      res.emplace_back(0);
    }
    for (int i = 0; i < n1 - n2; i++) {
      --scount[s[i] - 'a'];
      ++scount[s[i + n2] - 'a'];
      if (scount == pcount) {
        res.emplace_back(i + 1);
      }
    }
    return res;
  }
};