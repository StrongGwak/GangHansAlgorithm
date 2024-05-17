#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(int n) {
    vector<vector<int>> answer;
    int dx[4] = {0, 1, 0, -1};
    int dy[4] = {1, 0, -1, 0};
    int x = 0;
    int y = 0;
    int d = 0;
    for (int i = 0; i < n; i++) {
        vector<int> tmp;
        for (int j = 0; j < n; j++) {
            tmp.emplace_back(0);
        }
        answer.emplace_back(tmp);
    }
    
    for (int i = 1; i <= n*n; i++) {
        answer[x][y] = i;
        int mx = x + dx[d];
        int my = y + dy[d];
        if (mx >= answer.size() || my >= answer[0].size() || answer[mx][my] != 0) {
            d++;
            d %= 4;
            x += dx[d];
            y += dy[d];
        } else {
            x = mx;
            y = my;
        }
    }
    
    
    return answer;
}