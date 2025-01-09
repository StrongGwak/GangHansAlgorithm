#include <iostream>

using namespace std;

int nums[1001] = { 0, };

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;
	nums[1] = 1;

	for (int i = 2; i <= 1000; i++) {
		if (nums[i] == 0) {
			int num = i * 2;
			while (num <= 1000) {
				nums[num] = 1;
				num += i;
			}
		}
	}

	int result = 0;
	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		if (nums[num] == 0) {
			result++;
		}
	}

	cout << result;
}