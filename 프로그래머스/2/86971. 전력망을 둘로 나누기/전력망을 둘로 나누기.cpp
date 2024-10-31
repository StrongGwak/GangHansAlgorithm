#include <iostream>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

bool wire[101][101];
vector<bool> visited;
int cnt[2] = {0};
int m;
int l = 0;

int comp(int start) {
    int sum = 1;
    for (int i = 1; i <= l; i++) {
        if (!visited[i] && wire[start][i]) {
            visited[i] = true;
            sum += comp(i);
        }
    }
    return sum;
}

int solution(int n, vector<vector<int>> wires) {
    int answer = 100;
    l = n;
    for (int i = 0; i < wires.size(); i++) {
        wire[wires[i][0]][wires[i][1]] = true;
        wire[wires[i][1]][wires[i][0]] = true;
    }
    
    for (int i = 0; i < wires.size(); i++) {
        visited.assign(101, false);
        wire[wires[i][0]][wires[i][1]] = false;
        wire[wires[i][1]][wires[i][0]] = false;
        
        int idx = 0;
        for (int j = 1; j <= n; j++) {
            if (!visited[j]) {
                visited[j] = true;
                cnt[idx++] = comp(j);
            }
        }
        
        m = abs(cnt[0] - cnt[1]);
        
        if (answer > m) {
            answer = m;
        }      
        wire[wires[i][0]][wires[i][1]] = true;
        wire[wires[i][1]][wires[i][0]] = true;
    }
    
    return answer;
}