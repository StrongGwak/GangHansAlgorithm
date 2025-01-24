#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int E, S, M;
	cin >> E >> S >> M;
	int a = 1, b = 1, c = 1, count = 1;

	while (a != E || b != S || c != M) {
		a++;
		b++;
		c++;
		if (a == 16) {
			a = 1;
		}
		if (b == 29) {
			b = 1;
		}
		if (c == 20) {
			c = 1;
		}
		count++;
	}

	cout << count;
}