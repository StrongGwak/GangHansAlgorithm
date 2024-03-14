#include <string>
#include <vector>
#include <algorithm>
#include <stack>
#include <iostream>

using namespace std;

bool cmp(vector<string> &v1, vector<string> &v2){
    return v1[1]<v2[1];
}

vector<string> solution(vector<vector<string>> plans) {
    vector<string> answer;
    stack<int> leftWorks;
    vector<string> name;
    vector<int> start;
    vector<int> time;
    sort(plans.begin(), plans.end(), cmp);
    
    // 벡터 분리 및 시간변환
    for (int i = 0; i < plans.size(); i++) {
        int h = stoi(plans[i][1].substr(0, 2)) * 60;
        int m = stoi(plans[i][1].substr(3, 2));
        int t = stoi(plans[i][2]);
        
        name.push_back(plans[i][0]);
        start.push_back(h + m);
        time.push_back(t);
    }
    
    // 과제 시작
    for (int i = 0; i < plans.size(); i++) {
        int t = 0;
        if (i != plans.size() - 1) {
            t = time[i] - (start[i + 1] - start[i]);
        }
        if (t == 0) {
            answer.push_back(name[i]);
            continue;
        }
        
        if(t > 0) {
            time[i] = t;
            leftWorks.push(i);
        } else if (t < 0) {
            answer.push_back(name[i]);
            while (t < 0 && !leftWorks.empty()) {
                int num = leftWorks.top();
                t += time[num];
                if(t > 0) {
                    time[num] = t;
                    t = 0;
                } else {
                    answer.push_back(name[num]);
                    leftWorks.pop();
                }
            }
        }
    }
    
    while (!leftWorks.empty()) {
        int num = leftWorks.top();
        answer.push_back(name[num]);
        leftWorks.pop();
    }
    
    return answer;
}