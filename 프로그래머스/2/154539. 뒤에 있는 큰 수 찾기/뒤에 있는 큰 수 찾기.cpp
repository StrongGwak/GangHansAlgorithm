#include <string>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    stack<int> max;
    for (int i = numbers.size() - 1; i >= 0; i--) {
        if(max.empty()) {
            answer.push_back(-1);
            max.push(numbers[i]);
        } else if (numbers[i] < max.top()) {
            answer.push_back(max.top());
            max.push(numbers[i]);
        } else {
            max.pop();
            while(!max.empty()) {
                if(numbers[i] < max.top()) {
                    answer.push_back(max.top());
                    max.push(numbers[i]);
                    break;
                }
                max.pop();
            }
            if(max.empty()) {
                answer.push_back(-1);
                max.push(numbers[i]);
            }
        }
    }
    
    reverse(answer.begin(), answer.end());
    
    return answer;
}