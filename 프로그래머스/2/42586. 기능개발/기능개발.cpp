#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    // 현재 날짜
    int day = 0;
    for (int i = 0; i < progresses.size(); i++) {
        // 개발에 필요한 일정
        int work = ceil((float)(100 - progresses[i]) / speeds[i]);
        // 필요 일정이 현재 날짜보다 작으면
        if (day >= work) {
            // 완료
            answer.back()++;
        } else {
            // 현재 날짜로 갱신
            day = work;
            answer.push_back(1);
        }
    }
    return answer;
}
