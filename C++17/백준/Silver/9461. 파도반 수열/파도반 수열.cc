#include <iostream>

using namespace std;

int T,N;
long long dp[101];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> T;

	dp[1] = 1;
	dp[2] = 1;
	dp[3] = 1;
	dp[4] = 2;
	dp[5] = 2;

	for (int tc = 0; tc < T; tc++) {
		cin >> N;
		for (int i = 6; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}

		cout << dp[N] << '\n';
	}

}