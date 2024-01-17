#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    int cloth[31] = {1};
    for (int i = 1; i <= n; i++) {
        cloth[i] = 1;
    }
    for (int i = 0; i < lost.size(); i++) {
        cloth[lost[i]]--;
    }
    for (int i = 0; i < reserve.size(); i++) {
        cloth[reserve[i]]++;
    }
    for (int i = 1; i <= n; i++) {
        if (cloth[i] == 0) {
            if(i - 1 > 0 && cloth[i - 1] == 2) {
                cloth[i] = 1;
                cloth[i - 1] = 1;
            } else if (i + 1 <= n && cloth[i + 1] == 2) {
                cloth[i] = 1;
                cloth[i + 1] = 1;
            }
        }
    }
    
    for (int i = 1; i <= n; i++) {
        if (cloth[i] >= 1) {
            answer++;
        }
    }
    return answer;
}