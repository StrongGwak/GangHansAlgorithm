#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> strArr) {
    vector<string> answer;
    for (int i = 0; i < strArr.size(); i++) {
        bool flag = false;
        for (int j = 0; j < strArr[i].size() - 1; j++) {
            string ad = strArr[i].substr(j, 2);
            if (ad.compare("ad") == 0) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            answer.push_back(strArr[i]);
        }
    }
    return answer;
}