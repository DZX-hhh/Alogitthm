#include <bits/stdc++.h>
using namespace std;

vector<int> arr;
/* 归并排序 */
void merge(vector<int>& arr, int low, int mid, int high) {
	if (low < high) {
		vector<int> temp;
		for (auto num : arr) {
			temp.push_back(num);
		}
		int m = low, n = mid + 1;
		for (int i = low; i <= high; ++i) {
			if (m > mid) {
				arr[i] = temp[n++];
			} else if (n > high) {
				arr[i] = temp[m++];
			} else if (temp[m] < temp[n]) {
				arr[i] = temp[m++];
			} else if (temp[m] >= temp[n]) {
				arr[i] = temp[n++];
			}
		}
	}
}
void merge_sort(vector<int>& arr, int low, int high) {
	if (low < high) {
		int mid = low + (high - low) / 2;
		merge_sort(arr, low, mid);
		merge_sort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}
}

/* 快排 */
int partition(vector <int>& arr, int low, int high) {
	int num = arr[low];
	while (low < high) {
		while (low<high && arr[high]>num) {
			--high;
		}
		arr[low] = arr[high];
		while (low < high && arr[low] < num) {
			++low;
		}
		arr[high] = arr[low];
	}
	arr[low] = num;
	return low;
}
void quick_sort(vector <int>& arr, int low, int high) {
	if (low < high) {
		int pivot = partition(arr, low, high);
		quick_sort(arr, low, pivot);
		quick_sort(arr, pivot + 1, high);
	}
}

/* 产生随机数 */
void random(int length, int min, int max) {
	arr.clear();
	for (int i = 0; i < length; i++) {
		int num = min + rand() % (max - min);
		arr.push_back(num);
	}
}

void solve(int N) {
	random(N, 0, 100000);
	// sort(arr.begin(), arr.end());
	// quick_sort(arr, 0, arr.size());
	merge_sort(arr, 0, arr.size());
	for (auto num : arr) {
		cout << num << "\t";
	}
	cout << "\n";
}

int main() {
	//为了加速io
	ios::sync_with_stdio(false);//输入输出不同步
	cin.tie(nullptr);//将cin.cout解绑定

	int examples, N;
	cout << "input...examples:\t" << endl;
	cin >> examples;
	cout << "input...N:\t" << endl;
	cin >> N;
	for (int i = 0;i < examples;i++) {
		solve(N);
	}
}