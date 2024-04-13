#include <string>
#include <vector>

using namespace std;

string solution(string code) {
    string answer = "";
    int mode = 0;
    for (int i = 0; i < code.length(); i++) {
        string tmp = code.substr(i, 1);
        if (mode == 0) {
            if (tmp.compare("1") != 0) {
                if (i % 2 == 0) {
                    answer += tmp;
                }
            } else {
                mode = 1;
            }
        } else {
            if (tmp.compare("1") != 0) {
                if (i % 2 == 1) {
                    answer += tmp;
                }
            } else {
                mode = 0;
            }
        }
    }
    if (answer.compare("") == 0) {
        answer = "EMPTY";
    }
    return answer;
}