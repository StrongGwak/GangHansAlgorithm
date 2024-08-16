#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(vector<int> numbers, int target) {
    int answer = 0;
    queue<pair<int, int>> q;
    int cal[2] = {1, -1};
    q.emplace(make_pair(0, 0));
    while (!q.empty()) {
        pair<int, int> num = q.front();
        q.pop();
        for (int i = 0; i < 2; i++) {
            int sum = num.first + cal[i] * numbers[num.second];
            if (num.second == numbers.size() - 1) {
                if (sum == target) {
                    answer++;
                }
            } 
            else 
            {
                q.emplace(make_pair(sum, num.second + 1));
            }
        }
    }
    
    return answer;
}