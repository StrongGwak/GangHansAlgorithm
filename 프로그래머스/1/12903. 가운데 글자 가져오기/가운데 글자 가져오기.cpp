#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    int length = s.length();
    int middle = length/2;
    if (length % 2 == 0) {
        answer = string(1, s[middle - 1]) + string(1, s[middle]);
    } else {
        answer = string(1, s[middle]);
    }
    return answer;
}