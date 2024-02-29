#include <vector>
#include <set>

using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    set<int> num;
    
    for (int i = 0; i < nums.size(); i++) {
        num.insert(nums[i]);
    }
    
    if (nums.size() / 2 > num.size()) {
        answer = num.size();
    } else {
        answer = nums.size() / 2;
    }
    
    
    
    return answer;
}