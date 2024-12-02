#include <iostream>

using namespace std;

int N, T;
int seal[100001][2], dp[100001][2];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> T;

	for (int tc = 0; tc < T; tc++) {
		cin >> N;

		for (int i = 1; i <= N; i++) {
			cin >> seal[i][0];
		}

		for (int i = 1; i <= N; i++) {
			cin >> seal[i][1];
		}

		dp[1][0] = seal[1][0];
		dp[1][1] = seal[1][1];

		for (int i = 2; i <= N; i++) {
			dp[i][0] = max(dp[i - 1][1], max(dp[i - 2][0], dp[i - 2][1])) + seal[i][0];
			dp[i][1] = max(dp[i - 1][0], max(dp[i - 2][0], dp[i - 2][1])) + seal[i][1];
		}

		cout << max(dp[N][0], dp[N][1]) << '\n';
	}
}