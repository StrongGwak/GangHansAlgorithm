#include <iostream>

using namespace std;

int N;
int dp[10];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int result = 0;

	cin >> N;
	
	for (int i = 0; i < 10; i++) {
		dp[i] = 1;
	}

	for (int i = 0; i < N - 1; i++) {
		for (int j = 0; j < 10; j++) {
			for (int k = j + 1; k < 10; k++) {
				dp[j] = (dp[j] + dp[k]) % 10007;
			}
		}
	}

	for (int i = 0; i < 10; i++) {
		result += dp[i];
	}

	cout << result % 10007;
}