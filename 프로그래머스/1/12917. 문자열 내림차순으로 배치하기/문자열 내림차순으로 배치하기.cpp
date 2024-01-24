#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int desc(int a, int b) {
    return a > b;
}

string solution(string s) {
    string answer = "";
    vector<int> big;
    vector<int> small;
    for (int i = 0; i < s.length(); i++) {
        if (s[i] <= 90) {
            big.push_back(s[i]);
        } else {
            small.push_back(s[i]);
        }
    }
    sort(big.begin(), big.end(), desc);
    sort(small.begin(), small.end(), desc);
    
    for (int i = 0; i < small.size(); i++) {
        answer += small[i];
    }
    
    for (int i = 0; i < big.size(); i++) {
        answer += big[i];
    }
    
    return answer;
}