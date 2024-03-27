#include <string>
#include <vector>

using namespace std;

bool visited[8] = {false};
int m = 0;

void explore(vector<vector<int>> dungeons, int k, int l) {
    // 탐험한 최대 던전 수
    if(l > m) {
        m = l;
    }
    
    for (int i = 0; i < dungeons.size(); i++) {
        // 방문한 던전이라면 패스
        if(visited[i]) {
            continue;
        }
        // 최소 피로도보다 현재 피로도가 낮다면 패스
        if(dungeons[i][0] > k) {
            continue;
        }
        // 방문처리
        visited[i] = true;
        // 피로도 감소 및 탐험 수 증가
        explore(dungeons, k - dungeons[i][1], l + 1);
        // 미방문 처리
        visited[i] = false;
    }
    
}

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    explore(dungeons, k, 0);
    answer = m;
    return answer;
}
