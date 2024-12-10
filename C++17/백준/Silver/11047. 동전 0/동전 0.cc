#include <iostream>

using namespace std;

int N, K;
int nums[10];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> K;
	int result = 0;
	for (int i = 0; i < N; i++) {
		cin >> nums[i];
	}

	for (int i = N - 1; i >= 0; i--) {
		if (K == 0) {
			break;
		}
		else if (K < nums[i]) {
			continue;
		}
		else {
			result += K / nums[i];
			K %= nums[i];
		}
	}

	cout << result;
}