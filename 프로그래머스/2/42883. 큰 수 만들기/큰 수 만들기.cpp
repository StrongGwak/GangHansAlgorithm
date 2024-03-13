#include <string>
#include <vector>
#include <iostream>
#include <stack>
#include <algorithm>

using namespace std;

string solution(string number, int k) {
    stack<int> s;
    for (int i = 0; i < number.size(); i++) {
        if (s.empty()) {
            s.push(number[i] - '0'); 
            continue;
        }
        if (s.top() < number[i] - '0') {
            while(!s.empty() && s.top() < number[i] - '0' && k > 0) {
                s.pop();
                k--;
            }
            s.push(number[i] - '0'); 
        } else if (s.top() >= number[i] - '0') {
            s.push(number[i] - '0'); 
        }
    }
    while (k > 0) {
        s.pop();
        k--;
    }
    string answer = "";
    while (!s.empty()) {
        answer += to_string(s.top());
        s.pop();
    }
    reverse(answer.begin(), answer.end());
    return answer;
}