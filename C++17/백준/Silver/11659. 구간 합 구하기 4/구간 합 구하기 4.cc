#include <iostream>

using namespace std;

int N, M;
int dp[100001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;

	for (int i = 1; i <= N; i++) {
		cin >> dp[i];
		dp[i] += dp[i - 1];
	}
	
	for (int i = 0; i < M; i++) {
		int x, y;
		cin >> x >> y;
		cout << dp[y] - dp[x - 1] << '\n';
	}
}