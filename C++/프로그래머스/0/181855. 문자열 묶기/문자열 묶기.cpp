#include <string>
#include <vector>

using namespace std;

int solution(vector<string> strArr) {
    int answer = 0;
    int l[100001] = {0};
    int max = 0;
    for (int i = 0; i < strArr.size(); i++) {
        l[strArr[i].size()]++;
        if (max < strArr[i].size()) {
            max = strArr[i].size();
        }
    }
    
    for (int i = 1; i <= max; i++) {
        if (answer < l[i]) {
            answer = l[i];
        }
    }
    return answer;
}