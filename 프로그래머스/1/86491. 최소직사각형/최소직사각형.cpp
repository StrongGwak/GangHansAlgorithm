#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool desc(vector<int> a, vector<int> b) {
    return a > b;
}

bool descs(vector<int> a, vector<int> b) {
    return a[1] > b[1];
}

int solution(vector<vector<int>> sizes) {
    int answer = 0;
    int tmp = 0;
    for (int i = 0; i < sizes.size(); i++) {
        if(sizes[i][0] < sizes[i][1]) {
            tmp = sizes[i][0];
            sizes[i][0] = sizes[i][1];
            sizes[i][1] = tmp;
        }
    }
    sort(sizes.begin(), sizes.end(), desc);
    int w = sizes[0][0];
    sort(sizes.begin(), sizes.end(), descs);
    int h = sizes[0][1];
    answer = w * h;
    return answer;
}