#include <iostream>
#include <stack>
#include <vector>

int main() {
	int lastNum = 0;
	std::stack<int> s;
	std::vector<char> result;
	int currentNum = 1;
	bool flag = false;

	std::cin >> lastNum;
	
	for (int i = 0; i < lastNum; i++) {
		int num = 0;
		std::cin >> num;
		while (s.empty() || s.top() < num) {
			s.push(currentNum++);
			result.emplace_back('+');
		}
		
		if (s.top() == num) {
			s.pop();
			result.emplace_back('-');
		}
		else {
			flag = true;
			break;
		}
	}
	if (flag) {
		std::cout << "NO";
	}
	else {
		for (auto a : result) {
			std::cout << a << '\n';
		}
	}
}