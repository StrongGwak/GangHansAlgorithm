#include <iostream>

using namespace std;

int N;
int dp[1000001];
int route[1000001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;

	dp[2] = 1;
	route[2] = 1;
	dp[3] = 1;
	route[3] = 1;

	for (int i = 4; i <= N; i++) {
		dp[i] = dp[i - 1] + 1;
		route[i] = i - 1;

		if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
			dp[i] = dp[i / 2] + 1;
			route[i] = i / 2;
		}

		if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
			dp[i] = dp[i / 3] + 1;
			route[i] = i / 3;
		}
		
	}
	
	cout << dp[N] << '\n';
	while (N != 0) {
		cout << N << " ";
		N = route[N];
	}
}