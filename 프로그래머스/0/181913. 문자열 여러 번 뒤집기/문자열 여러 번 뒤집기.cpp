#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

string solution(string my_string, vector<vector<int>> queries) {
    string answer = "";
    vector<string> str;
    for (int i = 0; i < my_string.size(); i++) {
        string s(1, my_string[i]);
        str.push_back(s);
    }
    for (int i = 0; i < queries.size(); i++) {
        reverse(str.begin() + queries[i][0], str.begin() + queries[i][1] + 1);
    }
    for (int i = 0; i < str.size(); i++) {
        answer += str[i];
    }
    return answer;
}