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
	//����ÿ�����ӣ������1��->��1����������Ծ��
	for(int i=1; i<n; i++) {

		//������ǰ����ǰ������и��ӣ�����dp[i]
		for(int j=0; j<i; j++) {
			//����ӵ�j�����ӿ���������i������,j->i
			if(j+nums[j]>=i&&dp[j]!=-1) {
				if(dp[i]==-1||dp[i]>dp[j]+1) { //i���ɴ����i->���һ�����Ա�j�����ת��dp[j]+1
					dp[i]=dp[j]+1;//�����
				}
			}
		}
	}
	//���شӵ�һ�������������һ�����ӵ�������Ծ��
	if(dp[n-1]==-1) {
		cout <<"-1";
	} else {
		cout<<dp[n-1];
	}
	return 0;
}
