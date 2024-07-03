#include <iostream>
#include <list>
#include <string>

int main() {
	int n = 0;
	std::cin >> n;
	for (int t = 0; t < n; t++) {
		std::string order = "";
		std::cin >> order;
		std::list<char> words;
		std::list<char>::iterator iter = words.begin();
		for (int i = 0; i < order.size(); i++) {
			if (order[i] == '<') {
				if (iter != words.begin()) {
					iter--;
				}
			}
			else if (order[i] == '>') {
				if (iter != words.end()) {
					iter++;
				}
			}
			else if (order[i] == '-') {
				if (iter != words.begin()) {
					iter = words.erase(--iter);
				}
			}
			else {
				words.insert(iter, order[i]);
			}
		}
		for (auto result : words) {
			std::cout << result;
		}
		std::cout << '\n';
	}
	
}