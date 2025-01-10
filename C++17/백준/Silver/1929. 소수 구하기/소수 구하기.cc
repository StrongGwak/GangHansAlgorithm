#include <iostream>

using namespace std;

int nums[1000001] = { 0, };

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int M, N;
	cin >> M >> N;
	nums[1] = 1;

	for (int i = 2; i <= 1000000; i++) {
		if (nums[i] == 0) {
			int num = i * 2;
			while (num <= 1000000) {
				nums[num] = 1;
				num += i;
			}
		}
	}

	for (int i = M; i <= N; i++) {
		if (nums[i] == 0) {
			cout << i << '\n';
		}
	}
}