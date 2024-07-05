#include <iostream>
#include <stack>
#include <vector>

int main() {
	int n = 0;;
	std::stack<int> max;
	std::vector<int> nums;
	std::vector<int> result;
	std::cin >> n;
	for (int i = 0; i < n; i++) {
		int num = 0;
		std::cin >> num;
		nums.emplace_back(num);
	}

	for (int i = n - 1; i >= 0; i--) {
		while (!max.empty() && max.top() <= nums[i]) {
			max.pop();
		}
		if (max.empty() || max.top() < nums[i]) {
			result.emplace_back(-1);
		}
		else {
			result.emplace_back(max.top());
		}
		max.push(nums[i]);
	}

	for (int i = n - 1; i >= 0; i--) {
		std::cout << result[i] << ' ';
	}
}