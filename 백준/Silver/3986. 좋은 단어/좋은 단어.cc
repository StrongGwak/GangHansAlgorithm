#include <iostream>
#include <stack>

int main() {
	std::ios_base::sync_with_stdio(0);
	std::cin.tie(0);
	std::cout.tie(0);
	
	int n;
	int result = 0;
	std::cin >> n;
	for (int i = 0; i < n; i++) {
		std::stack<char> words;
		std::string word;
		std::cin >> word;
		for (int j = 0; j < word.size(); j++) {
			if (words.empty()) {
				words.push(word[j]);
			}
			else {
				if (words.top() == word[j]) {
					words.pop();
				}
				else {
					words.push(word[j]);
				}
			}
		}
		if (words.empty()) {
			result++;
		}
	}

	std::cout << result;
}