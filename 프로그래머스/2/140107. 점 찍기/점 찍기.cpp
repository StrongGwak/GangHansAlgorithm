#include <string>
#include <vector>
#include <cmath>
#include <iostream>

using namespace std;

long long solution(int k, int d) {
    long long answer = 0;
    long long dd = pow(d, 2);
    for (int i = 0; i <= d; i += k) {
        long long yy = dd - pow(i, 2);
        answer += ((int)sqrt(yy) / k) + 1;
    }
    return answer;
}