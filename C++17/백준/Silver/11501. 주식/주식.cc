#include <iostream>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;

	for (int tc = 0; tc < T; tc++) {
		int N;
		cin >> N;
		vector<int> nums;
		long long result = 0;
		int m = -1;
		for (int i = 0; i < N; i++) {
			int num;
			cin >> num;
			nums.emplace_back(num);
		}
		for (int i = N - 1; i >= 0; i--) {
			m = max(m, nums[i]);
			result += m - nums[i];
		}
		cout << result << '\n';
	}
}