#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int a, int b) {
    int answer = 0;
    int c = a % 2;
    int d = b % 2;
    if(c != 0 && d != 0) {
        answer = (a * a) + (b * b);
    } else if ((c == 0 && d != 0) || (c != 0 && d == 0)) {
        answer = 2 * (a + b);
    } else {
        answer = abs(a - b);
    }
    
    return answer;
}