#include <iostream>

using namespace std;

int T, W;
int dp[1001][31];
int nums[1001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> T >> W;

	for (int i = 1; i <= T; i++) {
		cin >> nums[i];
	}

	for (int i = 1; i <= T; i++) {
		for (int j = 0; j <= W; j++) {
			if ((j + 1) % 2 == nums[i] % 2) {
				dp[i][j] = dp[i - 1][j] + 1;
				if (j != 0) {
					dp[i][j] = max(dp[i - 1][j - 1], dp[i][j]);
				}
			}
			else {
				dp[i][j] = dp[i - 1][j];
				if (j != 0) {
					dp[i][j] = max(dp[i - 1][j - 1] + 1, dp[i][j]);
				}
			}
		}
	}

	cout << dp[T][W];
}