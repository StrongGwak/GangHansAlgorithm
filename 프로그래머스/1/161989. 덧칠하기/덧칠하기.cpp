#include <string>
#include <vector>

using namespace std;

int solution(int n, int m, vector<int> section) {
    int answer = 1;
    int painted = section[0] + m;
    for (int i = 1; i < section.size(); i++) {
        if(painted > section[i]) {
            continue;
        } else {
            painted = section[i] + m;
            answer++;
        }
    }
    return answer;
}