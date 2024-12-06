#include <iostream>

using namespace std;

int N;
int dp[100001][3];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int tc = 1;
	while (true) {
		cin >> N;
		if (N == 0) {
			break;
		}
		int n1, n2, n3;
		cin >> n1 >> n2 >> n3;
		dp[1][0] = 1000001;
		dp[1][1] = n2;
		dp[1][2] = n2 + n3;

		for (int i = 2; i <= N; i++) {
			cin >> n1 >> n2 >> n3;
			dp[i][0] = min(dp[i - 1][0], dp[i - 1][1]) + n1;
			dp[i][1] = min(dp[i - 1][0], min(dp[i - 1][1], min(dp[i - 1][2], dp[i][0]))) + n2;
			dp[i][2] = min(dp[i - 1][1], min(dp[i - 1][2], dp[i][1])) + n3;
		}
		cout << tc << ". " << dp[N][1] << '\n';
		tc++;
	}
	
}