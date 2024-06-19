#include <iostream>
#include <stack>

int main() {
	int k = 0;
	int result = 0;
	std::stack<int> nums;
	std::cin >> k;
	for (int i = 0; i < k; i++) 
	{
		int num = 0;
		std::cin >> num;
		if (num == 0) {
			nums.pop();
		}
		else {
			nums.push(num);
		}
	}
	
	while (!nums.empty()) {
		result += nums.top();
		nums.pop();
	}

	std::cout << result;
}