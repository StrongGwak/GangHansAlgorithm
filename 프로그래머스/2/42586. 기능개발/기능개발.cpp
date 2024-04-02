#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    int day = ceil((float)(100 - progresses[0]) / speeds[0]);
    int complete = 1;
    for (int i = 1; i < progresses.size(); i++) {
        int work = ceil((float)(100 - progresses[i]) / speeds[i]);
        if (day >= work) {
            complete++;
        } else {
            day = work;
            answer.push_back(complete);
            complete = 1;
        }
    }
    answer.push_back(complete);
    return answer;
}