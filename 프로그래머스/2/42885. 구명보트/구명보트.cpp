#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    vector<bool> escape;
    sort(people.begin(), people.end());
    // 가벼운 사람
    int front = 0;
    // 무거운 사람
    int back = people.size() - 1;
    // 투포인터로 만날때까지 반복
    while (front <= back) {
        if (people[front] + people[back] <= limit) {
            answer++;
            front++;
            back--;
        } else {
            back--;
            answer++;
        }
    }
    
    return answer;
}
