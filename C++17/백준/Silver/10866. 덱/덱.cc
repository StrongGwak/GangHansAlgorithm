#include <iostream>
#include <string>
#include <deque>

int main() {
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int n;
	std::deque<int> deq;
	std::cin >> n;
	for (int i = 0; i < n; i++) {
		std::string order;
		std::cin >> order;
		if (order == "push_front") {
			int num;
			std::cin >> num;
			deq.push_front(num);
		}
		else if (order == "push_back") {
			int num;
			std::cin >> num;
			deq.push_back(num);
		}
		else if (order == "pop_front") {
			if (deq.empty()) {
				std::cout << -1 << '\n';
			}
			else {
				std::cout << deq.front() << '\n';
				deq.pop_front();
			}
		}
		else if (order == "pop_back") {
			if (deq.empty()) {
				std::cout << -1 << '\n';
			}
			else {
				std::cout << deq.back() << '\n';
				deq.pop_back();
			}
		}
		else if (order == "size") {
			std::cout << deq.size() << '\n';
		}
		else if (order == "empty") {
			if (deq.empty()) {
				std::cout << 1 << '\n';
			}
			else {
				std::cout << 0 << '\n';
			}
		}
		else if (order == "front") {
			if (deq.empty()) {
				std::cout << -1 << '\n';
			}
			else {
				std::cout << deq.front() << '\n';
			}
		}
		else if (order == "back") {
			if (deq.empty()) {
				std::cout << -1 << '\n';
			}
			else {
				std::cout << deq.back() << '\n';
			}
		}
	}
}