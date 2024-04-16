#include <string>
#include <vector>

using namespace std;

string solution(string myString) {
    string answer = "";
    for (int i = 0; i < myString.size(); i++) {
        if (myString[i] - 'a' < 12) {
            answer += "l";
        } else {
            answer += myString.substr(i, 1);
        }
    }
    return answer;
}