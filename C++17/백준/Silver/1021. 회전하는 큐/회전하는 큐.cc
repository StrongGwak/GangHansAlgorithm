#include <iostream>
#include <string>
#include <deque>

int main() {
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int n, targets;
	int result = 0;
	std::deque<int> deq;
	std::cin >> n >> targets;
	for (int i = 1; i <= n; i++) {
		deq.push_back(i);
	}

	for (int i = 0; i < targets; i++) {
		int target;
		int count = 0;
		std::cin >> target;
		while (target != deq.front()) {
			deq.push_back(deq.front());
			deq.pop_front();
			count++;
		}
		int subCount = deq.size() - count;
		if (count > subCount) {
			result += subCount;
		}
		else {
			result += count;
		}
		deq.pop_front();
	}

	std::cout << result;
}