#include <iostream>
#include <string>

int main() {
    std::string word = "";
    int num[26] = { 0 };
    std::cin >> word;
    for (int i = 0; i < word.size(); i++) {
        num[word[i] - 97]++;
    }

    for (int i = 0; i < 26; i++) {
        std::cout << num[i] << " ";
    }

    return 0;
}