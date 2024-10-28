#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int A, B, C;
    cin >> A >> B >> C;

    cout << A + B - C << '\n';

    int tmp = B;
    int len = 0;

    while (tmp > 0) {
        tmp /= 10;
        A *= 10;
    }

    cout << A + B - C << '\n';
}