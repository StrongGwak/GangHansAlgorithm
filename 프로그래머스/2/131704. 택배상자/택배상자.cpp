#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(vector<int> order) {
    int answer = 0;
    stack<int> main;
    stack<int> sub;
    // 기존 컨테이너 벨트 스택에 상자 정보 삽입
    for (int i = order.size(); i >= 1; i--) {
        main.push(i);
    }
    
    while (!main.empty() || !sub.empty()) {
        // 트럭에 실었는지 여부
        bool flag = false;
        // 기존 컨테이너 벨트 체크
        if(!main.empty() && main.top() == order[answer]) {
            main.pop();
            answer++;
            flag = true;
        }
        // 보조 컨테이너 벨트 체크
        if(!sub.empty() && sub.top() == order[answer]) {
            sub.pop();
            answer++;
            flag = true;
        }
        // 싣지 못했다면 (기존 -> 보조) 상자 이동
        if (!main.empty() && !flag) {
            sub.push(main.top());
            main.pop();
        } else if (main.empty() && !flag) {
            // 기존 컨테이너 벨트에 상자가 없고 트럭에 싣지도 못했다면 종료
            break;
        }
    }
    return answer;
}
