#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    bool f = false;
    int first = -1;
    int last = -1;
    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] == 2) {
            if (!f) {
                f = true;
                first = i;
                last = i;
            } else {
                last = i;
            }
        }
    }
    if(first == -1) {
        answer.push_back(-1);
    } else {
        for (int i = first; i <= last; i++) {
            answer.push_back(arr[i]);
        }
    }
    
    
    return answer;
}
