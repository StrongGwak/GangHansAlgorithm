#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(int n) {
    int answer = 0;
    bool flag[n + 1];
    for (int i = 0; i < n + 1; i++) {
        flag[i] = true;
    }
    for (int i = 2; i <= sqrt(n); i++) {
        int j = 2;
        while (i * j <= n){
            flag[i * j] = false;
            j += 1;
        }
    }
    for (int i = 2; i < n + 1; i++) {
        if(flag[i]) {
            answer++;
        }
    }
    return answer;
}