#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int answer = 0;
    string ta = to_string(a);
    string tb = to_string(b);
    string tab = ta + tb;
    string tba = tb + ta;
    int ab = stoi(tab);
    int ba = stoi(tba);
    if(ab > ba) {
        answer = ab;
    } else {
        answer = ba;
    }
    return answer;
}