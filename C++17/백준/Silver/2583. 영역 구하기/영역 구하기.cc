#include <iostream>
#include <vector>
#include <algorithm>

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
std::vector<std::vector<bool>> map;
int M, N, K;

int dfs(int x, int y) {
    int move = 1;
    for (int i = 0; i < 4; i++) {
        int mx = x + dx[i];
        int my = y + dy[i];
        if (mx >= 0 && mx < M && my >= 0 && my < N && !map[mx][my]) {
            map[mx][my] = true;
            move += dfs(mx, my);
        }
    }
    return move;
}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(NULL);

    std::cin >> M >> N >> K;

    int result = 0;
    std::vector<int> ranges;

    for (int i = 0; i < M; i++) {
        std::vector<bool> tempMap;
        for (int j = 0; j < N; j++) {
            tempMap.emplace_back(false);
        }
        map.emplace_back(tempMap);
    }

    for (int i = 0; i < K; i++) {
        int startY, startX, endY, endX;
        std::cin >> startY >> startX >> endY >> endX;

        for (int x = startX; x < endX; x++) {
            for (int y = startY; y < endY; y++) {
                if (!map[x][y]) {
                    map[x][y] = true;
                }
            }
        }
    }
    
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            if (!map[i][j]) {
                map[i][j] = true;
                result++;
                ranges.emplace_back(dfs(i, j));
            }
        }
    }

    sort(ranges.begin(), ranges.end());
    
    std::cout << result << '\n';
    for (int i = 0; i < ranges.size(); i++) {
        std::cout << ranges[i] << " ";
    }
    std::cout << '\n';
}