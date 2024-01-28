#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers) {
    int answer = -1;
    int sum = 0;
    bool nums[10] = {false};
    
    for (int i = 0; i < numbers.size(); i++) {
        nums[numbers[i]] = true;
    }
    
    for (int i = 0; i < 10; i++) {
        if(!nums[i]) {
            sum += i;
        }
    }
    
    if (sum != 0) {
        answer = sum;
    }
    
    return answer;
}