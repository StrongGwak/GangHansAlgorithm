#include <iostream>

using namespace std;

int dp[1001][1001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	string A, B;
	cin >> A >> B;

	for (int i = 1; i <= A.length(); i++) {
		for (int j = 1; j <= B.length(); j++) {
			if (A[i - 1] == B[j - 1]) {
				dp[i][j] = dp[i - 1][j - 1] + 1;
			}
			else {
				dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
	}

	cout << dp[A.length()][B.length()];
}