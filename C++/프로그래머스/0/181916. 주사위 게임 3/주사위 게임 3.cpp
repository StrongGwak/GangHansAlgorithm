#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp (int a, int b) {
    return a > b;
}

int solution(int a, int b, int c, int d) {
    int answer = 0;
    vector<int> dice;
    
    dice.push_back(a);
    dice.push_back(b);
    dice.push_back(c);
    dice.push_back(d);
    sort(dice.begin(), dice.end(), cmp);
    
    if (dice[0] == dice[1] && dice[1] == dice[2] && dice[2] == dice[3]) {
        answer = 1111 * dice[0];
    } else if (dice[0] == dice[1] && dice[1] == dice[2]) {
        answer = 10 * dice[0] + dice[3];
        answer *= answer;
    } else if (dice[1] == dice[2] && dice[2] == dice[3]) {
        answer = 10 * dice[1] + dice[0];
        answer *= answer;
    } else if (dice[0] == dice[1] && dice[2] == dice[3]) {
        answer = (dice[0] + dice[3]) * (dice[0] - dice[3]);
    } else if (dice[0] == dice[1]) {
        answer = dice[2] * dice[3];
    } else if (dice[1] == dice[2]) {
        answer = dice[0] * dice[3];
    } else if (dice[2] == dice[3]) {
        answer = dice[0] * dice[1];
    } else {
        answer = dice[3];
    }
    
    return answer;
}