#include <iostream>

using namespace std;

int N;
int dp[100001], nums[100001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> nums[i];
	}
	int result = nums[1];

	for (int i = 1; i <= N; i++) {
		dp[i] = max(dp[i - 1] + nums[i], nums[i]);
		result = max(result, dp[i]);
	}
	
	cout << result;
}