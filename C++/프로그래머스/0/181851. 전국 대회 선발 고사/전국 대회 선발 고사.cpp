#include <string>
#include <vector>

using namespace std;

int solution(vector<int> rank, vector<bool> attendance) {
    int answer = 0;
    int result[3] = {10000, 100, 1};
    
    for (int i = 0; i < 3; i++) {
        int min = 101;
        int minIndex = 0;
        for (int j = 0; j < rank.size(); j++) {
            if (attendance[j] && rank[j] < min) {
                min = rank[j];
                minIndex = j;
            }
        }
        attendance[minIndex] = false;
        answer += result[i] * minIndex;
    }
    
    return answer;
}