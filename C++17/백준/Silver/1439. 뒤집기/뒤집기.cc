#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	string a;
	cin >> a;
	int n[2] = { 0, };
	for (int i = 0; i < a.length() - 1; i++) {
		if (i == 0) {
			n[a[i] - '0']++;
		}
		if (a[i] != a[i + 1]) {
			n[a[i + 1] - '0']++;
		}
	}
	cout << min(n[0], n[1]);
}