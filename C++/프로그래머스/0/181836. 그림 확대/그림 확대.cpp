#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> picture, int k) {
    vector<string> answer;
    for (int i = 0; i < picture.size(); i++) {
        string tmp = "";
        for (int j = 0; j < picture[i].size(); j++) {
            string p = picture[i].substr(j, 1);
            for (int l = 0; l < k; l++) {
                tmp += p;
            }
            
        }
        for (int l = 0; l < k; l++) {
            answer.emplace_back(tmp);
        }
    }
    return answer;
}