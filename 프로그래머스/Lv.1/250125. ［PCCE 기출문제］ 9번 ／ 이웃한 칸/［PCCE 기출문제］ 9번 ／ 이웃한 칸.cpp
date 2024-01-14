#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<string>> board, int h, int w) {
    int answer = 0;
    vector<int> dx = {0, 1, 0, -1};
    vector<int> dy = {-1, 0, 1, 0};
    string str = board[h][w];
    for (int i = 0; i < dx.size(); i++) {
        if(h + dx[i] >= 0 && h + dx[i] < board.size() && w + dy[i] >= 0 && w + dy[i] < board[h].size() && 
           str.compare(board[h + dx[i]][w + dy[i]]) == 0) {
            answer++;
        }
    }
    return answer;
}