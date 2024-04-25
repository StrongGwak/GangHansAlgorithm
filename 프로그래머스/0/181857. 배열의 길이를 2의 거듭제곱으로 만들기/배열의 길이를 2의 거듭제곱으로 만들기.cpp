#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    int two = 1;
    while (two < arr.size()) {
        two *= 2;
    }
    for (int i = 0; i < arr.size(); i++) {
        answer.push_back(arr[i]);
    }
    while (two != answer.size()) {
        answer.push_back(0);
    }
    return answer;
}