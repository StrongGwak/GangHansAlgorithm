#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<vector<int>> snale;
int num = 1;

vector<int> solution(int n) {
    vector<int> answer;
    int sum = (n * (n + 1)) / 2;
    for (int i = 1; i <= n; i++) {
        vector<int> temp(i, 0);
        snale.emplace_back(temp);
    }
    int start = 0, end = 1;
    
    while(sum >= num) {
        for (int i = start; i <= snale.size() - end; i++) {
            if (snale[i][start] != 0) {
                continue;
            }
            snale[i][start] = num++;
        }
        start++;
    
        for (int i = start; i <= snale[snale.size() - 1].size() - end; i++) {
            if (snale[snale.size() - end][i] != 0) {
                continue;
            }
            snale[snale.size() - end][i] = num++;
        }

        for (int i = snale.size() - 1 - end; i >= start; i--) {
            if (snale[i][snale[i].size() - end] != 0) {
                continue;
            }
            snale[i][snale[i].size() - end] = num++;
        }
        end++;
    }
    
    for (int i = 0; i < snale.size(); i++) {
        for (int j = 0; j < snale[i].size(); j++) {
            answer.emplace_back(snale[i][j]);
        }
    }
    return answer;
}