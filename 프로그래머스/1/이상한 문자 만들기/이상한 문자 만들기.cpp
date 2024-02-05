#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string s) {
    string answer = "";
    int words = 0;
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == 32) {
            words = 0;
            answer += " ";
        } else {
            if (words % 2 == 0) {
                if (s[i] >= 97) {
                    char c = s[i] - 32;
                    answer += string(1, c);
                } else {
                    answer += s[i];
                }
            } else {
                if (s[i] < 97) {
                    char c = s[i] + 32;
                    answer += string(1, c);
                } else {
                    answer += s[i];
                }
            }
            words++;
        }
    }
    return answer;
}
