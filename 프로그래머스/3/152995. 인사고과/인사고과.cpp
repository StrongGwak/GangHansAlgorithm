#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp (vector<int> a, vector<int> b) {

    return a[0] + a[1] > b[0] + b[1];
}

int solution(vector<vector<int>> scores) {
    int answer = 1;
    sort(scores.begin() + 1, scores.end(), cmp);
    
    for (int i = 1; i < scores.size(); i++) {
        if (scores[0][0] < scores[i][0] && scores[0][1] < scores[i][1]) {
            return -1;
        } else if (scores[0][0] + scores[0][1] < scores[i][0] + scores[i][1]) {
            answer++;
        } else {
            break;
        }
    }
    int rank = answer;
    for (int i = 2; i < rank; i++) {
        for (int j = 1; j < i; j++) {
            if (scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1]) {
                answer--;
                break;
            }
        }
    }

    return answer;
}