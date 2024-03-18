#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool cmp (vector<int> v1, vector<int> v2) {
    return v1[2] > v2[2];
}

int solution(vector<int> picks, vector<string> minerals) {
    int answer = 0;
    int dps[3] = {1, 1, 1};
    int ips[3] = {5, 1, 1};
    int sps[3] = {25, 5, 1};
    int ps[3] = {0};
    int mine = 0;
    int totalPicks = 0;
    vector<vector<int>> pick;
    for (int i = 0; i < picks.size(); i++) {
        totalPicks += picks[i];
    }
    for (int i = 0; i < minerals.size(); i++) {
        mine++;
        if(minerals[i].compare("diamond") == 0) {
            ps[0] += dps[0];
            ps[1] += ips[0];
            ps[2] += sps[0];
        } else if(minerals[i].compare("iron") == 0) {
            ps[0] += dps[1];
            ps[1] += ips[1];
            ps[2] += sps[1];
        } else if(minerals[i].compare("stone") == 0) {
            ps[0] += dps[2];
            ps[1] += ips[2];
            ps[2] += sps[2];
        }
        
        if(totalPicks > 0 && (mine % 5 == 0 || i == minerals.size() - 1)) {
            totalPicks--;
            pick.push_back(vector<int> ());
            pick[pick.size()-1].push_back(ps[0]);
            pick[pick.size()-1].push_back(ps[1]);
            pick[pick.size()-1].push_back(ps[2]);
            ps[0] = 0;
            ps[1] = 0;
            ps[2] = 0;
        }
    }
    
    sort(pick.begin(), pick.end(), cmp);
    
    for (int i = 0; i < pick.size(); i++) {
        if (picks[0] > 0) {
            answer += pick[i][0];
            picks[0]--;
        } else if (picks[1] > 0) {
            answer += pick[i][1];
            picks[1]--;
        } else if (picks[2] > 0) {
            answer += pick[i][2];
            picks[2]--;
        }
    }
    
    return answer;
}