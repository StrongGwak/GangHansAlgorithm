#include <string>
#include <vector>

using namespace std;

int solution(vector<int> topping) {
    int answer = 0;
    int lt[10001] = {0, };
    int rt[10001] = {0, };
    int r = 0;
    int l = 0;
    for (int i = 0; i < topping.size(); i++) {
        if (rt[topping[i]] == 0) {
            r++;
        }
        rt[topping[i]]++;
    }
    
    for (int i = 0; i < topping.size(); i++) {
        if (lt[topping[i]] == 0) {
            l++;
        }
        lt[topping[i]]++;
        if (rt[topping[i]] == 1) {
            r--;
        }
        rt[topping[i]]--;
        if (r == l) {
            answer++;
        }
    }
    return answer;
}