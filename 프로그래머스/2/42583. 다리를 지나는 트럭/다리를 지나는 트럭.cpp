#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    queue<pair<int, int>> bridge;
    for (auto i : truck_weights) {
        answer++;
        if (answer == bridge.front().second + bridge_length) {
            weight += bridge.front().first;
            bridge.pop();
        }
        while (weight - i < 0) {
            answer = bridge.front().second + bridge_length;
            weight += bridge.front().first;
            bridge.pop();
        }
        weight -= i;
        bridge.emplace(i, answer);
    }
    answer = bridge.back().second + bridge_length;
    return answer;
}