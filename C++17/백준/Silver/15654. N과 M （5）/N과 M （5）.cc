#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> nums, result;
vector<bool> isSelected;
int N, M;

void permutation(int cnt) {
	if (cnt == M) {
		for (int i = 0; i < cnt; i++) {
			cout << result[i] << " ";
		}
		cout << '\n';
		return;
	}

	for (int i = 0; i < N; i++) {
		if (!isSelected[i]) {
			isSelected[i] = true;
			result[cnt] = nums[i];
			permutation(cnt + 1);
			isSelected[i] = false;
		}
		
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		nums.emplace_back(num);
	}

	sort(nums.begin(), nums.end());

	isSelected.assign(N, false);
	result.assign(M, 0);

	permutation(0);
}