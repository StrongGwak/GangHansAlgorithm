#include <string>
#include <vector>

using namespace std;

vector<vector<int>> answer;

void hanoi(int a, int b, int n) {
    vector<int> move = {a, b};
    if (n == 1) {
        answer.emplace_back(move);
        return;
    }
    hanoi(a, 6 - a - b, n - 1);
    answer.emplace_back(move);
    hanoi(6 - a - b, b, n - 1);
}

vector<vector<int>> solution(int n) {
    hanoi(1, 3, n);
    return answer;
}