#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;
	int result = 1;
	if (N == 1) {
		cout << 1;
	}
	else {
		N -= 1;
		while (N > 0) {
			N -= 6 * result;
			result++;
		}
		cout << result;
	}
}