#include <iostream>

using namespace std;

int n[1001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
    int A, B;
    cin >> A >> B;
    
    int cnt = 0;
    for (int i = 1; cnt < 1000; i++) {
        for (int j = 0; j < i; j++) {
            n[cnt++] = i;
            if (cnt == 1000) {
                break;
            }
        }
    }
    int sum = 0;
    for (int i = A - 1; i <= B - 1; i++) {
        sum += n[i];
    }
    cout << sum;
}