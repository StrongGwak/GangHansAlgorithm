#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int answer = 0;
    string sa = to_string(a);
    string sb = to_string(b);
    string sab = sa + sb;
    if (stoi(sab) < 2 * a * b) {
        answer = 2 * a * b;
    } else {
        answer = stoi(sab);  
    }
    return answer;
}