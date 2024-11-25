#include <iostream>

using namespace std;

int N;
long long dp[91];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;

	dp[1] = 1;
	dp[2] = 1;

	for (int i = 2; i <= N; i++) {
		dp[i] = dp[i - 1] + dp[i - 2];
	}

	cout << dp[N];
}