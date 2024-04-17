#include<bits/stdc++.h>
using namespace std;


int main() {
	vector<int> nums;
	int n;
	cin>>n;
	for(int i=0; i<n; i++) {
		int num;
		cin>>num;
		nums.push_back(num);
	}
	vector<int> dp(n,-1);
	dp[0]=0;
	//遍历每个格子，计算第1个->第1个的最少跳跃数
	for(int i=1; i<n; i++) {

		//遍历当前格子前面的所有格子，更新dp[i]
		for(int j=0; j<i; j++) {
			//如果从第j个格子可以跳到第i个格子,j->i
			if(j+nums[j]>=i&&dp[j]!=-1) {
				if(dp[i]==-1||dp[i]>dp[j]+1) { //i不可达或者i->最后一个可以被j间接跳转到dp[j]+1
					dp[i]=dp[j]+1;//间接跳
				}
			}
		}
	}
	//返回从第一个格子跳到最后一个格子的最少跳跃数
	if(dp[n-1]==-1) {
		cout <<"-1";
	} else {
		cout<<dp[n-1];
	}
	return 0;
}
