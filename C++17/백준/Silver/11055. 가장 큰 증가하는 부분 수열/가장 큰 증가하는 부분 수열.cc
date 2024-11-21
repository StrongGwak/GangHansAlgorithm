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
	}
	int result = nums[1];
	dp[1] = nums[1];

	for (int i = 2; i <= N; i++) {
		dp[i] = nums[i];
		for (int j = i - 1; j >= 1; j--) {
			if (nums[i] > nums[j]) {
				dp[i] = max(nums[i] + dp[j], dp[i]);
			}
		}
		result = max(result, dp[i]);
	}
	
	cout << result;
}