#include <iostream>

using namespace std;

int N;
int dp[17], T[17], P[17];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;

	for (int i = 1; i <= N; i++) {
		cin >> T[i] >> P[i];
	}

	for (int i = N; i > 0; i--) {
		if (i + T[i] <= N + 1) {
			dp[i] = max(dp[i + T[i]] + P[i], dp[i + 1]);
		}
		else {
			dp[i] = dp[i + 1];
		}
	}

	cout << dp[1];
}