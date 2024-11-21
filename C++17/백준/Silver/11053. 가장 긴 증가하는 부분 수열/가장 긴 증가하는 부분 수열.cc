#include <iostream>

using namespace std;

int N;
int dp[1010], nums[1010];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> nums[i];
		dp[i] = 1;
	}
	int result = 0;

	for (int i = 1; i <= N; i++) {
		for (int j = i - 1; j >= 1; j--) {
			if (nums[i] > nums[j]) {
				dp[i] = max(dp[j] + 1, dp[i]);
			}
		}
		result = max(result, dp[i]);
	}
	
	cout << result;
}