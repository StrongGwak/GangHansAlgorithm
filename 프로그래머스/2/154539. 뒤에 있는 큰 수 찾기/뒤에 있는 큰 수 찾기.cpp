#include <string>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    // 이전 크기들을 저장하는 스택
    stack<int> max;
    // 뒤에서부터 시작
    for (int i = numbers.size() - 1; i >= 0; i--) {
        // 스택이 비어있다면 맨뒤라서 -1 삽입
        if(max.empty()) {
            answer.push_back(-1);
            max.push(numbers[i]);
        // 스택의 top 보다 작다면 top 삽입 후 스택에 현재 값 삽입
        } else if (numbers[i] < max.top()) {
            answer.push_back(max.top());
            max.push(numbers[i]);
        // 스택의 top 보다 크다면
        } else {
            // top 값 삭제
            max.pop();
            // 반복문 시작
            while(!max.empty()) {
                // top 값 제거 후 새로운 top 값 비교
                if(numbers[i] < max.top()) {
                    // top 값이 크다면 종료
                    answer.push_back(max.top());
                    max.push(numbers[i]);
                    break;
                }
                max.pop();
            }
            // 반복문 종료 후 스택이 비어있다면 현재 값이 가장 큰 값
            if(max.empty()) {
                answer.push_back(-1);
                max.push(numbers[i]);
            }
        }
    }
    
    // 뒤에서부터 했기 때문에 뒤집어줌
    reverse(answer.begin(), answer.end());
    
    return answer;
}
