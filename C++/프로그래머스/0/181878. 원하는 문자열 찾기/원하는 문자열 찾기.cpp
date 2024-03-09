#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string myString, string pat) {
    int answer = 0;
    for (auto &c : myString) {
        c = toupper(c);
    }
    for (auto &c : pat) {
        c = toupper(c);
    }
    for (int i = 0; i < myString.size(); i++) {
        if(myString[i] == pat[0]) {
            if(myString.substr(i, pat.size()).compare(pat) == 0) {
                answer = 1;
                break;
            }
        }
    }
    return answer;
}