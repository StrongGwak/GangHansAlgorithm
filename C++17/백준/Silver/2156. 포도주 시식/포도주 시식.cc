#include <iostream>

using namespace std;

int N;
int dp[10001], nums[10001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;

	for (int i = 1; i <= N; i++) {
		cin >> nums[i];
	}

	dp[1] = nums[1];
	dp[2] = nums[1] + nums[2];

	for (int i = 3; i <= N; i++) {
		dp[i] = max(dp[i - 3] + nums[i - 1] + nums[i], max(dp[i - 2] + nums[i], dp[i - 1]));
	}

	cout << dp[N];
	
}