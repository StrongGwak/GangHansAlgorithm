#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int tc = 1;
	while (true) {
		int L, P, V, result = 0;
		cin >> L >> P >> V;
		if (L == 0 && P == 0 && V == 0) {
			break;
		}

		result = (V / P) * L + min((V % P), L);

		cout << "Case " << tc++ << ": " << result << '\n';
	}
}