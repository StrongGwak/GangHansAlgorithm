#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <iostream>

using namespace std;

int sortn = 0;
bool cmp(vector<int> v1, vector<int> v2){
    return v1[sortn] < v2[sortn];
}

vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    vector<vector<int>> answer;
    int extn = 0;
    
    if (ext.compare("date") == 0) {
        extn = 1;
    } else if (ext.compare("maximum") == 0) {
        extn = 2;
    } else if (ext.compare("remain") == 0) {
        extn = 3;
    }
    
    if (sort_by.compare("date") == 0) {
        sortn = 1;
    } else if (sort_by.compare("maximum") == 0) {
        sortn = 2;
    } else if (sort_by.compare("remain") == 0) {
        sortn = 3;
    }
    
    for (int i = 0; i < data.size(); i++) {
        if(data[i][extn] < val_ext) {
            answer.push_back(data[i]);
        }
    }
    
    sort(answer.begin(), answer.end(), cmp);
    
    return answer;
}