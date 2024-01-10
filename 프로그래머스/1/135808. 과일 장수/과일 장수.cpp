#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool desc(int a, int b){ 
  return a > b; 
} 

int solution(int k, int m, vector<int> score) {
    int answer = 0;
    sort(score.begin(), score.end(), desc);
    for (int i = m - 1; i < score.size(); i = i + m) {
        answer += score[i] * m;
    }
    return answer;
}