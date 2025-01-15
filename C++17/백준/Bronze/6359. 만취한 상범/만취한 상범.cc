#include <iostream>

using namespace std;

int nums[101] = {1};

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;
	
	for (int tc = 0; tc < T; tc++) {
		int N;
		cin >> N;

		for (int i = 1; i <= 100; i++) {
			nums[i] = 1;
		}

		int result = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				if (j % i == 0) {
					nums[j]++;
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			if (nums[i] % 2 == 1) {
				result++;
			}
		}

		cout << result << '\n';
	}
}