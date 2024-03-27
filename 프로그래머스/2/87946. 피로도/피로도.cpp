#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool visited[8] = {false};
int m = 0;

void explore(vector<vector<int>> dungeons, int k, int l) {
    if(l > m) {
        m = l;
    }
    
    for (int i = 0; i < dungeons.size(); i++) {
        if(visited[i]) {
            continue;
        }
        if(dungeons[i][0] > k) {
            continue;
        }
        visited[i] = true;
        explore(dungeons, k - dungeons[i][1], l + 1);
        visited[i] = false;
    }
    
}

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    explore(dungeons, k, 0);
    answer = m;
    return answer;
}