#include <iostream>
#include <string>
#include <stack>

int main() {
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int T;
	std::cin >> T;
	
	for (int i = 0; i < T; i++) {
		std::string word;
		std::cin >> word;
		std::stack<char> s;
		for (int j = 0; j < word.size(); j++) {
			if (!s.empty() && word[j] == ')' && s.top() == '(') {
				s.pop();
			}
			else {
				s.push(word[j]);
			}
		}
		if (s.empty()) {
			std::cout << "YES" << '\n';
		}
		else {
			std::cout << "NO" << '\n';
		}
	}
}