#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    int answer = 0;
    string tmp = "";
    if (myString.size() < pat.size()) {
        return 0;
    }
    for (int i = 0; i < myString.size(); i++) {
        if (myString.substr(i, 1).compare("A") == 0) {
            tmp += "B";
        } else {
            tmp += "A";
        }
    }
    
    for (int i = 0; i <= tmp.size() - pat.size(); i++) {
        if (tmp.substr(i, pat.size()).compare(pat) == 0) {
            return 1;
        }
    }
    return answer;
}