#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    int score[25] = {0};
    int choice[7] = {3, 2, 1, 0, 1, 2, 3};
    for (int i = 0; i < survey.size(); i++) {
        if (choices[i] < 4) {
            score[survey[i][0] - 'A'] += choice[choices[i] - 1];
        } else if (choices[i] > 4) {
            score[survey[i][1] - 'A'] += choice[choices[i] - 1];
        }
    }
    
    if (score['R' - 'A'] >= score['T' - 'A']) {
        answer += "R";
    } else {
        answer += "T";
    }
    if (score['C' - 'A'] >= score['F' - 'A']) {
        answer += "C";
    } else {
        answer += "F";
    }
    if (score['J' - 'A'] >= score['M' - 'A']) {
        answer += "J";
    } else {
        answer += "M";
    }
    if (score['A' - 'A'] >= score['N' - 'A']) {
        answer += "A";
    } else {
        answer += "N";
    }
    return answer;
}
