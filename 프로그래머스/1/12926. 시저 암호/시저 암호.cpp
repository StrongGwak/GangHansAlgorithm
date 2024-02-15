#include <string>
#include <vector>

using namespace std;

string solution(string s, int n) {
    string answer = "";
    for (int i = 0; i < s.size(); i++) {
        int a = s[i];
        if (a >= 65 && a <= 90) {
            answer += (a - 65 + n) % 26 + 65;
        } else if (a >= 97 && a <= 122) {
            answer += (a - 97 + n) % 26 + 97;
        } else {
            answer += " ";
        }
    }
    return answer;
}