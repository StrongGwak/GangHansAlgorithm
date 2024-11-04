#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> nums, result;
int N, M;

void combination(int cnt, int start) {
	if (cnt == M) {
		for (int i = 0; i < M; i++) {
			cout << result[i] << " ";
		}
		cout << '\n';
		return;
	}

	for (int i = start; i < N; i++) {
		result[cnt] = nums[i];
		combination(cnt + 1, i);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;
	nums.assign(N, 0);
	result.assign(M, 0);

	for (int i = 0; i < N; i++) {
		cin >> nums[i];
	}

	sort(nums.begin(), nums.end());

	combination(0, 0);

}