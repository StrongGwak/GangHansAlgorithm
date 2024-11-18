#include <iostream>
#include <vector>

using namespace std;

int N;
int dp[1001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;

	dp[1] = 1;
	dp[2] = 2;

	for (int i = 3; i <= N; i++) {
		dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
	}
	
	cout << dp[N];
}