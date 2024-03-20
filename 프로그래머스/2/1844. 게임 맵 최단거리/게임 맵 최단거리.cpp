#include<vector>
#include<queue>

using namespace std;

// 위치와 거리 구조체
struct Node {    
    int x;
    int y;
    int r;
};

int bfs(vector<vector<int>> maps) {
    // 방문 여부
    vector<vector<bool>> visited;
    visited.resize(maps.size());
    for(int i = 0; i < visited.size(); i++) {
        visited[i].resize(maps[i].size());
    }
    // 탐색 범위
    int dx[4] = {0, 1, 0, -1};
    int dy[4] = {1, 0, -1, 0};
    queue<Node> q;
    // 탐색 시작
    q.push({0, 0, 1});
    visited[0][0] = true;
    
    while (!q.empty()) {
        Node a = q.front();
        q.pop();
        // 맵의 우측 하단 도착시 값 리턴
        if (a.x == maps.size() - 1 && a.y == maps[0].size() - 1) {
            return a.r;
        }
        for (int i = 0; i < 4; i++) {
            int mx = a.x + dx[i];
            int my = a.y + dy[i];
            // 이동 후 위치 조건
            // 맵을 벗어났는지, 해당 위치가 벽인지, 방문 했는지
            if (mx >= 0 && my >= 0 
                && mx < maps.size() && my < maps[0].size() 
                && maps[mx][my] != 0 && !visited[mx][my]) {
                // 이동 후 방문 처리
                q.push({mx, my, a.r + 1});
                visited[mx][my] = true;
            }
        }
    }
    // 도착 불가면 -1 리턴
    return -1;
    
}

int solution(vector<vector<int>> maps)
{
    int answer = 0;
    answer = bfs(maps);
    return answer;
}