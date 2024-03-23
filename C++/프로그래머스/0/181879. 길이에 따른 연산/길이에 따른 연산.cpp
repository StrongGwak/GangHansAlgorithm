#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int answer = 0;
    int l = num_list.size();
    if (l > 10) {
        for(int i = 0; i < l; i++) {
            answer += num_list[i];
        }
    } else {
        answer = 1;
        for(int i = 0; i < l; i++) {
            answer *= num_list[i];
        }
    }
    return answer;
}