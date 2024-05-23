#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> arr) {
    int answer = 0;
    int count = arr.size();
    bool change[1000001];
    while (true) {
        for (int i = 0; i < arr.size(); i++) {
            if (change[i]) {
                continue;
            }
            if (arr[i] >= 50) {
                if (arr[i] % 2 == 0) {
                    arr[i] /= 2;
                } else {
                    change[i] = true;
                    count--;
                }
            } else {
                if (arr[i] % 2 == 1) {
                    arr[i] = arr[i] * 2 + 1;
                } else {
                    change[i] = true;
                    count--;
                }
            }
            
        }
        if (count == 0) {
            return answer;
        }
        answer++;
        
    }
    return answer;
}