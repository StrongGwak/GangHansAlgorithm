#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list) {
    vector<int> answer;
    for (int i = 0; i < num_list.size(); i++) {
        answer.push_back(num_list[i]);
    }
    int size = answer.size();
    if(answer[size-1] > answer[size-2]) {
        answer.push_back(answer[size-1] - answer[size-2]);
    } else {
        answer.push_back(answer[size-1] * 2);
    }
    return answer
