#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr) {
    vector<vector<int>> answer;
    int col = arr.size();
    int row = arr[0].size();
    if (col > row) {
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < col - row; j++) {
                arr[i].emplace_back(0);
            }
        }
    } else {
        vector<int> tmp;
        for (int i = 0; i < row; i++) {
            tmp.emplace_back(0);
        }
        for (int i = 0; i < row - col; i++) {
            arr.emplace_back(tmp);
        }
    }
    answer = arr;
    return answer;
}