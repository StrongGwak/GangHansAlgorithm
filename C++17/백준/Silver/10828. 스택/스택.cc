#include <iostream>
#include <stack>
#include <string>

int main() {
	int n = 0;
	std::stack<int> s;
	std::cin >> n;
	for (int i = 0; i < n; i++) {
		int num = 0;
		std::string order = "";
		std::cin >> order;
		if (order == "push") {
			std::cin >> num;
			s.push(num);
		}
		else if (order == "pop") {
			if (s.empty()) {
				std::cout << -1 << '\n';
			}
			else {
				std::cout << s.top() << '\n';
				s.pop();
			}
		}
		else if (order == "size") {
			std::cout << s.size() << '\n';
		}
		else if (order == "empty") {
			if (s.empty()) {
				std::cout << 1 << '\n';
			}
			else {
				std::cout << 0 << '\n';
			}
		}
		else if (order == "top") {
			if (s.empty()) {
				std::cout << -1 << '\n';
			}
			else {
				std::cout << s.top() << '\n';
			}
		}
	}
	
}