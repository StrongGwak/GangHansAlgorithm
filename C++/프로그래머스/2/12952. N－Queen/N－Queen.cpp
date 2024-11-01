#include <string>
#include <vector>
#include <cstdlib>

using namespace std;

vector<int> row;
int result = 0;

bool check(int num) {
    for (int i = 0; i < num; i++) {
        if (row[i] == row[num] || abs(row[i] - row[num]) == num - i) {
            return false;
        }
    }
    return true;
    
}

void nq(int num) {
    if (!check(num - 1)) {
        return;
    }
    
    if (num == row.size()) {
        result++;
        return;
    }
    
    for (int i = 0; i < row.size(); i++) {
        row[num] = i;
        nq(num + 1);
    }
}

int solution(int n) {
    int answer = 0;
    row.assign(n, 0);
    nq(0);
    answer = result;
    return answer;
}