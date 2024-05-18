#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(int n) {
    vector<vector<int>> answer;
    for (int i = 0; i < n; i++) {
        vector<int> tmp;
        for (int j = 0; j < n; j++) {
            if (i == j) {
                tmp.emplace_back(1);
            } else {
                tmp.emplace_back(0);
            }
        }
        answer.emplace_back(tmp);
    }
    return answer;
}