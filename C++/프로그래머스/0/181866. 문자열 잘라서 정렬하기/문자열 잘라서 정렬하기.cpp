#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

vector<string> solution(string myString) {
    vector<string> answer;
    stringstream ss(myString);
    string tmp;
    while (getline(ss, tmp, 'x')) {
        if (tmp.compare("") == 0) {
            continue;
        }
        answer.push_back(tmp);
    }
    
    sort(answer.begin(), answer.end());
    
    return answer;
}