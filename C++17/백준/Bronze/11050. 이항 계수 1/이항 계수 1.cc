#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int Factorial(int N) {
    if (N <= 1)
        return 1;
    else
        return N * Factorial(N - 1);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, K;
    cin >> N >> K;

    cout << Factorial(N) / (Factorial(K) * Factorial(N - K));
}