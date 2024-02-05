#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

bool f(pair<int, double> a, pair<int, double> b) {
    if(a.second == b.second) {
        return a.first < b.first;
    } 
    return a.second > b.second;
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<int> clear;
    vector<pair<int, double>> fails;
    int players = stages.size();
    
    for (int i = 0; i < N + 2; i++) {
        clear.push_back(0);
    }
    
    for (int i = 0; i < players; i++) {
        clear[stages[i]]++;
    }
    
    for (int i = 1; i <= N; i++) {
        double fail = clear[i] / (double)players;
        fails.push_back(make_pair(i, fail));
        players -= clear[i];
    }
    
    stable_sort(fails.begin(), fails.end(), f);
    
    for (int i = 0; i < fails.size(); i++) {
        answer.push_back(fails[i].first);
    }
    
    return answer;
}
