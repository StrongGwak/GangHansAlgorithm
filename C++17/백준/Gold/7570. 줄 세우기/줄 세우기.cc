#include <iostream>

using namespace std;

int nums[1000001] = { 0, };

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int N;
	int result = 1;
	cin >> N;

	for (int i = 1; i <= N; i++) {
		int num;
		cin >> num;
		nums[num] = nums[num - 1] + 1;
		result = max(result, nums[num]);
	}

	cout << N - result;
}