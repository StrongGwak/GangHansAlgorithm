#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> strArr) {
    vector<string> answer;
    for (int i = 0; i < strArr.size(); i++) {
        if ((i + 1) % 2 == 0) {
            for (int j = 0; j < strArr[i].size(); j++) {
                if(strArr[i][j] >= 97) {
                    strArr[i][j] -= 32;
                }
            }
        } else {
            for (int j = 0; j < strArr[i].size(); j++) {
                if(strArr[i][j] <= 90) {
                    strArr[i][j] += 32;
                }
            }
        }
        answer.push_back(strArr[i]);
    }
    return answer;
}