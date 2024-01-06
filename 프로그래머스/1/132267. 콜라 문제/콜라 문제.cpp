#include <string>
#include <vector>

using namespace std;

int solution(int a, int b, int n) {
    int answer = 0;
    while(a <= n) {
        int coke = (n / a) * b;
        int empty = n % a;
        answer += coke;
        n = coke + empty;
    }
    return answer;
}