#include <iostream>
#include <string>
#include <vector>

int main() {
    int n = 0;
    std::vector<std::string> result;

    std::cin >> n;
    for (int i = 0; i < n; i++) 
    {
        std::string word1 = "";
        std::string word2 = "";
        int num[2][26] = { 0 };
        bool flag = false;
        std::cin >> word1 >> word2;

        for (int i = 0; i < word1.size(); i++) {
            num[0][word1[i] - 97]++;
        }
        for (int i = 0; i < word2.size(); i++) {
            num[1][word2[i] - 97]++;
        }

        for (int i = 0; i < 26; i++) {
            if (num[0][i] != num[1][i]) {
                flag = true;
                result.push_back("Impossible");
                break;
            }
        }
        if (!flag) {
            result.push_back("Possible");
        }
    }

    for (int i = 0; i < n; i++) {
        std::cout << result[i] << '\n';
    }
    return 0;
}