#include <iostream>
#include <stack>
#include <vector>

int main() {
	int n = 0;;
	long long result = 0;
	std::stack<int> max;
	std::vector<int> talls;
	std::vector<int> same(500001, 1);
	std::cin >> n;
	for (int i = 0; i < n; i++) {
		int tall = 0;
		std::cin >> tall;
		talls.emplace_back(tall);
	}

	for (int i = 0; i < n; i++) {
		while (!max.empty() && talls[max.top()] < talls[i]) {
			result += same[max.top()];
			max.pop();
		}
		if (!max.empty() && talls[max.top()] == talls[i]) {
			result += same[max.top()];
			same[i] += same[max.top()];
			max.pop();
			if (!max.empty()) {
				result++;
			}
		}
		else if (!max.empty() && talls[max.top()] > talls[i]) {
			result++;
		}
		max.push(i);
	}

	std::cout << result;

}