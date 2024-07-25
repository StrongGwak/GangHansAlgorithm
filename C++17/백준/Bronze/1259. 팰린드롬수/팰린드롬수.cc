#include <iostream>

int main() {
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	while (true) {
		std::string num;
		std::cin >> num;
		int size = num.size();
		bool flag = false;
		if (num == "0") {
			break;
		}
		for (int i = 0; i < size / 2; i++) {
			if (num[i] != num[size - 1 - i]) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			std::cout << "yes" << '\n';
		}
		else 
		{
			std::cout << "no" << '\n';
		}
	}
}