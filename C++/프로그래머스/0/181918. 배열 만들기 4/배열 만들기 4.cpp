#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> stk;
    int index = 0;
    while (index < arr.size()) {
        if (stk.empty()) {
            stk.push_back(arr[index++]);
        } else {
            if (stk[stk.size() - 1] < arr[index]) {
                stk.push_back(arr[index++]);
            } else {
                stk.pop_back();
            }
        }
    }
    return stk;
}