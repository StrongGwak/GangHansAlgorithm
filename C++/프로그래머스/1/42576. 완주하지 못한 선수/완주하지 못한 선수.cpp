#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    unordered_multiset<string> start;
    for (int i = 0; i < participant.size(); i++) {
        start.insert(participant[i]);
    }
    
    for (int i = 0; i < completion.size(); i++) {
        start.erase(start.find(completion[i]));
    }
    
    auto it = start.begin();
    answer = *it;
    
    return answer;
}