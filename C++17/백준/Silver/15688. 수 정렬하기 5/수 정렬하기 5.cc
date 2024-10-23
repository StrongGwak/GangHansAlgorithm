#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;

	vector<int> nums;

	for (int t = 0; t < n; t++) {
		int num;
		cin >> num;
		nums.emplace_back(num);
	}

	sort(nums.begin(), nums.end());

	for (int i = 0; i < nums.size(); i++) {
		cout << nums[i] << '\n';
	}

}