#include <iostream>
#include <vector>

using namespace std;

int T, N, K;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> T;
	for (int tc = 0; tc < T; tc++) {
		int dp[10001] = { 0 };
		dp[0] = 1;
		cin >> N;
		vector<int> nums;
		for (int i = 0; i < N; i++) {
			int num;
			cin >> num;
			nums.emplace_back(num);
		}

		cin >> K;
		for (int i = 0; i < N; i++) {
			for (int j = nums[i]; j <= K; j++) {
				dp[j] += dp[j - nums[i]];
			}
		}
		cout << dp[K] << '\n';
	}
}