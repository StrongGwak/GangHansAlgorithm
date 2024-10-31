#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    queue<pair<int, int>> q;
    priority_queue<int> pq;
    for (int i = 0; i < priorities.size(); i++) {
        q.push(make_pair(priorities[i], i));
        pq.push(priorities[i]);
    }
    while (!q.empty()) {
        int p = q.front().first;
        int idx = q.front().second;
        q.pop();
        if (p == pq.top()) {
            answer++;
            if (idx == location) {
                break;
            }
            pq.pop();
        }
        else {
            q.push(make_pair(p, idx));
        }
    }
    return answer;
}