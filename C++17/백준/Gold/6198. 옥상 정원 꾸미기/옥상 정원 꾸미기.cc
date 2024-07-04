#include <iostream>
#include <stack>
#include <vector>

int main() {
	int n = 0;;
	long long result = 0;
	std::stack<int> heights;
	std::vector<int> tops;
	std::cin >> n;
	for (int i = 0; i < n; i++) {
		int height = 0;
		std::cin >> height;
		tops.emplace_back(height);
	}

	for (int i = n - 1; i >= 0; i--) {
		while (!heights.empty() && tops[heights.top()] < tops[i]) {
			heights.pop();
		}
		
		if (heights.empty()) {
			heights.push(i);
			result += n - 1 - i;
		}
		else {
			result += heights.top() - 1 - i;
			heights.push(i);
		}
	}
	std::cout << result;
}