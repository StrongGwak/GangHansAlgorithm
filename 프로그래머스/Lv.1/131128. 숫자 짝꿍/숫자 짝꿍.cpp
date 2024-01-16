#include <string>
#include <vector>
#include <algorithm>
#include <functional>

using namespace std;

string solution(string X, string Y) {
    string answer = "";
    int x[10] = {0};
    int y[10] = {0};
    for (int i = 0; i < X.length(); i++) {
        x[X[i] - '0']++;
    }
    for (int i = 0; i < Y.length(); i++) {
        y[Y[i] - '0']++;
    }
    
    for (int i = 9; i >= 0; i--) {
        int n = min(x[i], y[i]);
        for (int j = 0; j < n; j++) {
            answer += to_string(i);
        }
    }
    
    if(answer[0] == '0') {
        answer = "0";
    } else if (answer == "") {
        answer = "-1";
    }
    return answer;
}