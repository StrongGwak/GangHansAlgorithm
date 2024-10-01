#include <iostream>
#include <vector>
#include <queue>

int M, N, K;

int bfs(std::vector<std::vector<int>> map) {
    int dx[4] = { -1, 0, 1, 0 };
    int dy[4] = { 0, 1, 0, -1 };

    int bug = 0;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (map[i][j] == 1) {
                bug++;
                std::queue<std::pair<int, int>> q;
                q.push(std::make_pair(i, j));
                map[i][j] = 0;
                while (!q.empty()) {
                    int x = q.front().first;
                    int y = q.front().second;
                    q.pop();

                    for (int k = 0; k < 4; k++) {
                        int mx = x + dx[k];
                        int my = y + dy[k];
                        if (mx >= 0 && mx < N && my >= 0 && my < M && map[mx][my] == 1) {
                            q.push(std::make_pair(mx, my));
                            map[mx][my] = 0;
                        }
                    }

                }
            }
        }
    }
    return bug;
}

int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(NULL);
    int TestCase;
    std::cin >> TestCase;
    for (int t = 0; t < TestCase; t++) {
        std::cin >> M >> N >> K;
        std::vector<std::vector<int>> map;
        
        for (int i = 0; i < N; i++) {
            std::vector<int> tempMap;
            std::vector<bool> tempVisited;
            for (int j = 0; j < M; j++) {
                tempMap.emplace_back(0);
            }
            map.emplace_back(tempMap);
        }

        for (int i = 0; i < K; i++) {
            int x, y;
            std::cin >> x >> y;
            map[y][x] = 1;
        }
        std::cout << bfs(map) << '\n';
    }
}