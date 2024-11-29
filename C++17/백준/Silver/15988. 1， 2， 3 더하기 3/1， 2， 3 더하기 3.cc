#include <iostream>

using namespace std;

int N, T;
long long dp[1000001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> T;

	int num = 4;

	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;

	for (int tc = 0; tc < T; tc++) {
		cin >> N;

		for (int i = num; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
		}

		cout << dp[N] << '\n';
		num = max(num, N);
	}
	
}