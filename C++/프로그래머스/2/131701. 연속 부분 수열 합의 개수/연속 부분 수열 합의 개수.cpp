#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> elements) {
    int answer = 0;
    int nums[1000001] = {0, };
    int len = elements.size();
    
    while (len != 0) {
        for (int i = 0; i < elements.size(); i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += elements[(i + j) % elements.size()];
            }
            if (nums[sum] == 0) {
                nums[sum]++;
                answer++;
            }
        }
        len--;
    }
    
    return answer;
}