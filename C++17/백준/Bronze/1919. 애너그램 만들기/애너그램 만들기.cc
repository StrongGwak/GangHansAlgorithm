#include <iostream>
#include <string>

int main() {
    std::string word1 = "";
    std::string word2 = "";
    int num[2][26] = { 0 };
    int result = 0;

    std::cin >> word1 >> word2;

    for (int i = 0; i < word1.size(); i++) {
        num[0][word1[i] - 97]++;
    }
    for (int i = 0; i < word2.size(); i++) {
        num[1][word2[i] - 97]++;
    }

    for (int i = 0; i < 26; i++) {
        if (num[0][i] > num[1][i]) {
            result += num[0][i] - num[1][i];
        }
        else {
            result += num[1][i] - num[0][i];
        }
    }

    std::cout << result;

    return 0;
}