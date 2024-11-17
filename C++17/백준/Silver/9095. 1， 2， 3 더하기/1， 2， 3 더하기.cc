#include <iostream>
#include <vector>

using namespace std;

int dp[12];
int T,N;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> N;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		cout << dp[N] << '\n';
	}
}