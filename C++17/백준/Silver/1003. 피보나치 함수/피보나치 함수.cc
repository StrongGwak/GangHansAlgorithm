#include <iostream>

using namespace std;

int T, N;
int dp[45][2];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> T;

	dp[0][0] = 1;
	dp[1][1] = 1;
	dp[2][0] = 1;
	dp[2][1] = 1;

	for (int i = 0; i < T; i++) {
		cin >> N;
		
		for (int j = 3; j <= N; j++) {
			dp[j][0] = dp[j - 2][0] + dp[j - 1][0];
			dp[j][1] = dp[j - 2][1] + dp[j - 1][1];
		}

		cout << dp[N][0] << " " << dp[N][1] << '\n';
	}
	
	
}