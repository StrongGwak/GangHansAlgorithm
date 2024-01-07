#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> students;
    for (int i = 0; i < 3; i++) {
        students.push_back(0);
    }
    vector<int> a = {1, 2, 3, 4, 5};
    vector<int> b = {2, 1, 2, 3, 2, 4, 2, 5};
    vector<int> c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    int maxScore = 0;
    for (int i = 0; i < answers.size(); i++) {
        if(a[i % a.size()] == answers[i]) {
            students[0]++;
        }
        if(b[i % b.size()] == answers[i]) {
            students[1]++;
        }
        if(c[i % c.size()] == answers[i]) {
            students[2]++;
        }
    }
    printf("%d %d %d", students[0], students[1], students[2]);
    for(int i = 0; i < students.size(); i++) {
        if(students[i] > maxScore) {
            maxScore = students[i];
        }
    }
    for(int i = 0; i < students.size(); i++) {
        if(students[i] == maxScore) {
            answer.push_back(i+1);
        }
    }
    return answer;
}