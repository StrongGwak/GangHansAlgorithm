#include <iostream>
#include <cmath>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;
    for (int testcase = 0; testcase < T; testcase++) {
        int H, W, N;
        cin >> H >> W >> N;

        int x = N % H;
        if (x == 0) {
            x = H;
        }
        int y = ceil((float)N / (float)H);

        if (y < 10) {
            cout << x << '0' << y;
        }
        else {
            cout << x << y;
        }
        cout << '\n';
    }
}