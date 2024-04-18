#include <string>
#include <vector>

using namespace std;

string solution(string rny_string) {
    string answer = "";
    for (int i = 0; i < rny_string.size(); i++) {
        string tmp = rny_string.substr(i, 1);
        if (tmp.compare("m") == 0) {
            answer += "rn";
        } else {
            answer += tmp;
        }
    }
    return answer;
}