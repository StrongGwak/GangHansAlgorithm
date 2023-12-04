#include <string>
#include <vector>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    string answer = "Yes";
    int cardIndex1 = 0;
    int cardIndex2 = 0;
    for (int i = 0; i < goal.size(); i++) {
        if(cardIndex1 < cards1.size() && goal[i].compare(cards1[cardIndex1]) == 0) {
            cardIndex1++;
        } else if (cardIndex2 < cards2.size() && goal[i].compare(cards2[cardIndex2]) == 0) {
            cardIndex2++;
        } else {
            answer = "No";
            return answer;
        }
    }
    return answer;
}