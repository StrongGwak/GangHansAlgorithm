#include <string>
#include <iostream>

using namespace std;

int solution(string dartResult) {
    int answer = 0;
    int now = 0;
    int prev = 0;
    string num = "";
    for (int i = 0; i < dartResult.size(); i++) {
        if (dartResult[i] - '0' >= 0 && dartResult[i] - '0' <= 10) {
            num += dartResult[i];
            if(dartResult[i + 1] - '0' >= 0 && dartResult[i + 1] - '0' <= 10) {
                continue;
            } else {
                answer += prev;
                prev = now;
                now = stoi(num);
                num = "";
            }
            
        } else if (dartResult[i] == 'D') {
            now = now * now;
        } else if (dartResult[i] == 'T') {
            now = now * now * now;
        } else if (dartResult[i] == '*') {
            now *= 2;
            prev *= 2;
        } else if (dartResult[i] == '#') {
            now *= -1;
        }
    }
    answer += now + prev;
    return answer;
}