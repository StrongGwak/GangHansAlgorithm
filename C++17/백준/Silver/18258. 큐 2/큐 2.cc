#include <iostream>
#include <string>
#include <queue>

int main() {
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int n;
	std::queue<int> q;
	std::cin >> n;
	for (int i = 0; i < n; i++) {
		std::string order;
		std::cin >> order;
		if (order == "push") {
			int num;
			std::cin >> num;
			q.push(num);
		}
		else if (order == "pop") {
			if (q.empty()) {
				std::cout << -1 << '\n';
			}
			else {
				std::cout << q.front() << '\n';
				q.pop();
			}
		}
		else if (order == "size") {
			std::cout << q.size() << '\n';
		}
		else if (order == "empty") {
			if (q.empty()) {
				std::cout << 1 << '\n';
			}
			else {
				std::cout << 0 << '\n';
			}
		}
		else if (order == "front") {
			if (q.empty()) {
				std::cout << -1 << '\n';
			}
			else {
				std::cout << q.front() << '\n';
			}
		}
		else if (order == "back") {
			if (q.empty()) {
				std::cout << -1 << '\n';
			}
			else {
				std::cout << q.back() << '\n';
			}
		}
	}
}