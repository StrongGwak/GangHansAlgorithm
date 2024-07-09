#include <iostream>
#include <string>
#include <deque>
#include <sstream>

bool isDelimiter(char ch, const std::string delimiters) {
	return delimiters.find(ch) != std::string::npos;
}

std::deque<int> split(std::string input, std::string delimiters) {
	std::deque<int> tokens;
	std::string token;

	for (char ch : input) {
		if (isDelimiter(ch, delimiters)) {
			if (!token.empty()) {
				tokens.push_back(stoi(token));
				token.clear();
			}
		}
		else {
			token += ch;
		}
	}

	if (!token.empty()) {
		tokens.push_back(stoi(token));
	}

	return tokens;
}

int main() {
	int t;
	std::cin >> t;
	std::string delimiters = "[,]";
	for (int i = 0; i < t; i++) {
		bool reverse = false;
		bool error = false;
		std::deque<int> deq;
		std::string order;
		int size;
		std::string nums;
		std::cin >> order;
		std::cin >> size;
		std::cin >> nums;
		deq = split(nums, delimiters);
		for (int j = 0; j < order.size(); j++) {
			if (order[j] == 'R') {
				if (reverse) {
					reverse = false;
				}
				else {
					reverse = true;
				}
			}
			else {
				if (deq.empty()) {
					error = true;
					break;
				}
				if (reverse) {
					deq.pop_back();
				}
				else {
					deq.pop_front();
				}
			}
		}
		if (error) {
			std::cout << "error" << '\n';
		} 
		else {
			std::cout << "[";
			if (!reverse) {
				while (!deq.empty()) {
					if (deq.size() == 1) {
						std::cout << deq.front();
						deq.pop_front();
					}
					else {
						std::cout << deq.front() << ",";
						deq.pop_front();
					}
				}
			}
			else {
				while (!deq.empty()) {
					if (deq.size() == 1) {
						std::cout << deq.back();
						deq.pop_back();
					}
					else {
						std::cout << deq.back() << ",";
						deq.pop_back();
					}
				}
			}
			std::cout << "]" << '\n';
		}
		
	}
}