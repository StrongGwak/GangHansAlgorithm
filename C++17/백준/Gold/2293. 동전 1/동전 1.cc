#include <iostream>
#include <vector>

using namespace std;

vector<int> dp;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n, k;
	cin >> n >> k;

	vector<int> dp(k + 1);
	dp[0] = 1;

	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		for (int j = num; j <= k; j++) {
			dp[j] += dp[j - num];
		}
	}

	cout << dp[k];
}