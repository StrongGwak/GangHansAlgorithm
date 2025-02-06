#include <iostream>
#include <vector>

using namespace std;

int GCD(int a, int b) {
    if (a % b == 0) {
        return b;
    }
    else {
        return GCD(b, a % b);
    }
}

long long LCM(int a, int b) {
    return ((long long)a * b) / GCD(a, b);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

    int T;
    cin >> T;
    for (int tc = 0; tc < T; tc++) {
        int a, b;
        cin >> a >> b;
        cout << LCM(a, b) << '\n';
    }
}