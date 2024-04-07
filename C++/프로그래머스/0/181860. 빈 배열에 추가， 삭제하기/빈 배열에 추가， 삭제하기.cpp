#include <string>
#include <vector>
#include <deque>

using namespace std;

vector<int> solution(vector<int> arr, vector<bool> flag) {
    vector<int> answer;
    deque<int> dq;
    for (int i = 0; i < arr.size(); i++) {
        if (flag[i]) {
            for (int j = 0; j < arr[i] * 2; j++) {
                dq.push_back(arr[i]);
            }
        } else {
            for (int j = 0; j < arr[i]; j++) {
                dq.pop_back();
            }
        }
    }
    
    for (auto i : dq) {
        answer.push_back(i);
    }
    
    return answer;
}