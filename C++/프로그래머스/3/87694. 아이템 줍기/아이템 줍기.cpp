#include <iostream>
#include <string>
#include <vector>
#include <queue>

using namespace std;

int map[102][102] = {0, };
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
int result = 0;

void dfs(int startX, int startY, int endX, int endY, int move) {
    for (int i = 0; i < 4; i++) {
        int mx = startX + dx[i];
        int my = startY + dy[i];
        if (mx >= 0 && mx < 102 && my >= 0 && my < 102 && map[mx][my] == 1) {
            if (mx == endX && my == endY) {
                if(result == 0) {
                    result = move;
                } else {
                    if (result > move) {
                        result = move;
                    }
                }
            } else {
                map[mx][my] = 3;
                dfs(mx, my, endX, endY, move + 1);
            }
        }
    }
}

int solution(vector<vector<int>> rectangle, int characterX, int characterY, int itemX, int itemY) {
    int answer = 0;
    for (int i = 0; i < rectangle.size(); i++) {
        for (int j = rectangle[i][1] * 2; j <= rectangle[i][3] * 2; j++) {
            for (int k = rectangle[i][0] * 2; k <= rectangle[i][2] * 2; k++) {
                map[j][k] = 1;
            }
        }
    }
    
    for (int i = 0; i < rectangle.size(); i++) {
        for (int j = rectangle[i][1] * 2 + 1; j <= rectangle[i][3] * 2 - 1; j++) {
            for (int k = rectangle[i][0] * 2 + 1; k <= rectangle[i][2] * 2 - 1; k++) {
                map[j][k] = 2;
            }
        }
    }
    
    map[characterY * 2][characterX * 2] = 2;
    
    dfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2, 1);
    
    return result / 2;
}