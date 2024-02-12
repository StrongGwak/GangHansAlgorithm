#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n) {
    int answer = 0;
    int t = 1;
    vector<int> threes;
    
    while(n != 0) {
        threes.push_back(n % 3);
        n /= 3;
    }
    
    for (int i = threes.size() - 1; i >= 0; i--) {
        answer += threes[i] * t;
        t *= 3;
    }
    
    return answer;
}