#include <string>
#include <vector>

using namespace std;

string solution(int a, int b) {
    string answer = "";
    int month[12] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    string day[7] = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
    int num = 0;
    for (int i = 0; i < a - 1; i++) {
        num += month[i];
    }
    answer = day[(num + b) % 7];
    
    return answer;
}