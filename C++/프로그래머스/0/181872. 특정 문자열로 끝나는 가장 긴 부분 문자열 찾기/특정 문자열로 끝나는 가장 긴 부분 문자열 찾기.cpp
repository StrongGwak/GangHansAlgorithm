#include <string>
#include <vector>

using namespace std;

string solution(string myString, string pat) {
    string answer = "";
    int l = 0;
    for (int i = 0; i <= myString.size() - pat.size(); i++) {
        if (myString.substr(i, pat.size()).compare(pat) == 0) {
            l = i + pat.size();
        }
    }
    for (int i = 0; i < l; i++) {
        answer += myString[i];
    }
    return answer;
}