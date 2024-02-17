#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    bool wins[6] = {false};
    int zero = 0;
    int win = 0;
    int rate[7] = {6, 6, 5, 4, 3, 2, 1};
    for (int i = 0; i < lottos.size(); i++) {
        if (lottos[i] == 0) {
            zero++;
            continue;
        }
        for (int j = 0; j < win_nums.size(); j++) {
            if (wins[j]) {
                continue;
            } else {
                if(lottos[i] == win_nums[j]) {
                    win++;
                    wins[j] = true;
                }
            }
        }
    }
    answer.push_back(rate[win + zero]);
    answer.push_back(rate[win]);
    return answer;
}