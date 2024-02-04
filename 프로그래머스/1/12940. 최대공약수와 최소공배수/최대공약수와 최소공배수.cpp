#include <string>
#include <vector>

using namespace std;

int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

vector<int> solution(int n, int m) {
    vector<int> answer;
    int g = 0;
    if(n > m) {
        g = gcd(n, m);
    } else {
        g = gcd(m, n);
    }
    answer.push_back(g);
    answer.push_back(n * m / g);
    
    return answer;
}