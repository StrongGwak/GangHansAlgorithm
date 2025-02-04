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

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

    int T;
    cin >> T;
    for (int tc = 0; tc < T; tc++) {
        int n;
        long long result = 0;
        cin >> n;
        vector<int> v;
        for (int i = 0; i < n; i++) {
            int num;
            cin >> num;
            v.emplace_back(num);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                result += GCD(v[i], v[j]);
            }
        }
        cout << result << '\n';
    }
}