#include <iostream>

using namespace std;

int N, Vip;
int dp[41];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;
	dp[0] = 1;
	dp[1] = 1;
	dp[2] = 2;

	for (int i = 3; i <= N; i++) {
		dp[i] = dp[i - 1] + dp[i - 2];
	}

	cin >> Vip;

	int result = 1;
	int start = 1;
	int v = 1, s = 0;
	for (int i = 1; i <= Vip; i++) {
		cin >> v;
		s = v;
		v -= start;

		result *= dp[v];
		start = s + 1;
	}
	result *= dp[N - s];
	cout << result;
}