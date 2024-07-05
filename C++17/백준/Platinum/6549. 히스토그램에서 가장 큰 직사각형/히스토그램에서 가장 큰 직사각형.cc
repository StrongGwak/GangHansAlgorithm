#include <iostream>
#include <stack>
#include <vector>

int main() {
	while (true) {
		int n;
		long long result = -1;
		std::stack<int> top;
		std::vector<int> h;
		std::cin >> n;
		if (n == 0) {
			break;
		}
		for (int i = 0; i < n; i++) {
			int height = 0;
			std::cin >> height;
			h.emplace_back(height);
		}

		for (int i = 0; i < n; i++) {
			while (!top.empty() && h[top.top()] > h[i]) {
				long long height = h[top.top()];
				int length = i;
				top.pop();
				if (!top.empty()) {
					length = i - 1 - top.top();
				}

				if (result < length * height) {
					result = length * height;
				}
			}
			top.push(i);
		}

		while (!top.empty()) {
			long long height = h[top.top()];
			int length = n;
			top.pop();
			if (!top.empty()) {
				length = n - 1 - top.top();
			}

			if (result < length * height) {
				result = length * height;
			}
		}
		std::cout << result << '\n';
	}
}