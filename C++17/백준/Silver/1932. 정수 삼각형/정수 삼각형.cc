#include <iostream>
#include <vector>

using namespace std;

int N;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;

	vector<vector<int>> nums(N, vector<int>());

	for (int i = 0; i < N; i++) {
		for (int j = 0; j <= i; j++) {
			int num;
			cin >> num;
			nums[i].emplace_back(num);
		}
	}

	for (int i = 1; i < N; i++) {
		for (int j = 0; j <= i; j++) {
			if (j == 0) {
				nums[i][j] += nums[i - 1][j];
			}
			else if (j == nums[i].size() - 1) {
				nums[i][j] += nums[i - 1][j - 1];
			}
			else {
				nums[i][j] += max(nums[i - 1][j - 1], nums[i - 1][j]);
			}
		}
	}

	int max = 0;

	for (int i = 0; i < N; i++) {
		if (max < nums[N-1][i]) {
			max = nums[N-1][i];
		}
	}
	
	cout << max;
}