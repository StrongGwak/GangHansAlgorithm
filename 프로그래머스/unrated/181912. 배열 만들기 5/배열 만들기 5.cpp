#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> intStrs, int k, int s, int l) {
    vector<int> answer;
    for (int i = 0; i < intStrs.size(); i++) {
        int str = stoi(intStrs[i].substr(s, l));
        if(str > k) {
            answer.push_back(str);
        }
    }
    return answer;
}