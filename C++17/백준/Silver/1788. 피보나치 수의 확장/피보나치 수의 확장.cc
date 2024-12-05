#include <iostream>

using namespace std;

int N;
long long dp[1000001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;

    dp[1] = 1;
    dp[2] = 1;
	
    for (int i = 3; i <= 1000000; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
    }
    if (N < 0) {
        if ((-N) % 2 == 0) {
            cout << -1 << '\n' << dp[-N];
        }
        if ((-N) % 2 != 0) {
            cout << 1 << '\n' << dp[-N];
        }
    }
    else if (N > 0) {
        cout << 1 << '\n' << dp[N];
    }
    else {
        cout << 0 << '\n' << 0;
    }
}