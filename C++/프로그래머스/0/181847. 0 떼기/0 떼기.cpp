#include <string>
#include <vector>

using namespace std;

string solution(string n_str) {
    string answer = "";
    bool zeroStart = false;
    bool zeroEnd = false;
    for (int i = 0; i < n_str.size(); i++) {
        string tmp = n_str.substr(i, 1);
        if (!zeroEnd && tmp.compare("0") == 0) {
            if (!zeroStart) {
                zeroStart = true;
            }
        } else {
            if (!zeroStart) {
                zeroStart = true;
            }
            if (zeroStart && !zeroEnd) {
                zeroEnd = true;
            }
            answer += tmp;
        }
    }
    return answer;
}