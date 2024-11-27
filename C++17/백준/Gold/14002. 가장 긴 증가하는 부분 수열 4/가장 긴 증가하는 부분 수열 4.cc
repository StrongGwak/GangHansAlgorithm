#include <iostream>
#include <vector>

using namespace std;

int N;
int dp[1001], nums[1001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;

	for (int i = 1; i <= N; i++) {
		cin >> nums[i]; 
		dp[i] = 1;
	}

	int result = 1;

	for (int i = 2; i <= N; i++) {
		for (int j = i - 1; j >= 1; j--) {
			if (nums[i] > nums[j]) {
				dp[i] = max(dp[j] + 1, dp[i]);
			}
		}
		result = max(dp[i], result);
	}

	cout << result << '\n';
	vector<int> r;
	for (int i = N; i > 0; i--) {
		if (dp[i] == result) {
			r.emplace_back(nums[i]);
			result--;
		}
	}

	for (int i = r.size() - 1; i >= 0; i--) {
		cout << r[i] << " ";
	}
	
}