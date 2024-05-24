#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    for (int i = 0; i < arr.size(); i++) {
        if (answer.empty()) {
            answer.emplace_back(arr[i]);
        } else if (answer.back() == arr[i]) {
            answer.pop_back();
        } else {
            answer.emplace_back(arr[i]);
        }
    }
    if (answer.empty()) {
        answer.emplace_back(-1);
    }
    return answer;
}