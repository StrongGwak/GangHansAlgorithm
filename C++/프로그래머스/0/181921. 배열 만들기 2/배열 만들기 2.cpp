#include <string>
#include <vector>

using namespace std;

vector<int> solution(int l, int r) {
    vector<int> answer;
    for (int i = l; i <= r; i++) {
        bool flag = false;
        if (i % 5 != 0) {
            continue;
        }
        int tmp = i;
        while (tmp >= 10) {
            tmp /= 10;
            if (tmp % 5 != 0) {
                flag = true;
                break;
            }
        }
        if(flag) {
            continue;
        }
        answer.push_back(i);
    }
    if (answer.empty()) {
        answer.push_back(-1);
    }
    return answer;
}