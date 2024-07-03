#include <iostream>
#include <list>
#include <string>

int main() {
	std::list<char> words;
	std::string word = "";
	std::cin >> word;
	for (int i = 0; i < word.size(); i++) {
		words.emplace_back(word[i]);
	}
	std::list<char>::iterator iter = words.end();
	int n = 0;
	std::cin >> n;
	for (int i = 0; i < n; i++) {
		std::string order = "";
		std::cin >> order;
		if (order == "L") {
			if (iter != words.begin()) {
				iter--;
			}
		}
		else if (order == "D") {
			if (iter != words.end()) {
				iter++;
			}
		}
		else if (order == "B") {
			if (iter != words.begin()) {
				iter = words.erase(--iter);
			}
		}
		else if (order == "P") {
			char add;
			std::cin >> add;
			words.insert(iter, add);
		}
	}
	for (auto w : words) {
		std::cout << w;
	}
}