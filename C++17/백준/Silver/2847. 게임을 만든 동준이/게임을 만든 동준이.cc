#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int N, result = 0;
	cin >> N;
	
	int nums[101] = { 0, };

	for (int i = 0; i < N; i++) {
		cin >> nums[i];
	}

	for (int i = N - 2; i >= 0; i--) {
		if (nums[i + 1] < nums[i]) {
			result += nums[i] - nums[i + 1] + 1;
			nums[i] = nums[i + 1] - 1;
		}
		else if (nums[i + 1] == nums[i]) {
			nums[i]--;
			result++;
		}
	}

	cout << result;
}