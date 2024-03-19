#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int n, int k, vector<int> enemy) {
    int answer = 0;
    // 이전 가장 많은 적의 라운드를 저장 하기위한 우선순위 큐
    priority_queue<int, vector<int>, less<int>> pq;
    for (int i = 0; i < enemy.size(); i++) {
        // 병사가 적보다 많으면 병사 - 적
        // 이후 해당 라운드 적을 큐에 저장
        n -= enemy[i];
        pq.push(enemy[i]);
        // 병사가 적보다 적고 무적권이 없다면 게임 종료
        if (n < 0 && k == 0) {
            break;
        } else if (n < 0 && k > 0) {
            // 이전 라운드 정보중 가장 적의 수가 많은 라운드에 무적권 사용
            while (!pq.empty() && n < 0){
                n += pq.top();
                pq.pop();
                k--;
            }
        }
        answer++;
    }
    return answer;
}