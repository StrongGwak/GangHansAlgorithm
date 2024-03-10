#include <vector>
#include <iostream>

using namespace std;

int numbers[3] = {0};
int answer = 0;

bool primality(int n) {
    int i = 2;
    while (i * i <= n) {
        if (n % i == 0) {
            return false;
        }
        i += 1;
    }
    return true;
}

void combination(int count, int next, int sum, vector<int> num) {
    if(count == 3) {
        if (primality(sum)) {
            answer++;
        }
        return;
    }
    
    for (int i = next; i < num.size(); i++) {
        sum += num[i];
	    combination(count + 1, i + 1, sum, num);
        sum -= num[i];
    }
}

int solution(vector<int> nums) {
    combination(0, 0, 0, nums);
    return answer;
}