#include <iostream>
#include <vector>

using namespace std;

int dp[301][2], S[301];
int N;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;

	for (int i = 1; i <= N; i++) {
		cin >> S[i];
	}

	dp[1][0] = S[1];
	dp[1][1] = 0;
	dp[2][0] = S[2];
	dp[2][1] = dp[1][0] + S[2];

	for (int i = 3; i <= N; i++) {
		dp[i][0] = max(dp[i - 2][0], dp[i - 2][1]) + S[i];
		dp[i][1] = dp[i - 1][0] + S[i];
	}

	cout << max(dp[N][0], dp[N][1]);

}