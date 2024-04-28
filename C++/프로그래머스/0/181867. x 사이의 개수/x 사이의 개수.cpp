#include <string>
#include <vector>

using namespace std;

vector<int> solution(string myString) {
    vector<int> answer;
    int cnt = 0;
    for (int i = 0; i < myString.size(); i++) {
        if (myString.substr(i, 1).compare("x") == 0) {
            answer.push_back(cnt);
            cnt = 0;
        } else {
            cnt++;
        }
    }
    answer.push_back(cnt);
    return answer;
}