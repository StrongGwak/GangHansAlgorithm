#include <iostream>

using namespace std;

bool checked[1001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, K;
	cin >> N >> K;
	int num = 2;
	int count = 0;
	for (int i = 2; i <= N; i++) {
		int num = i;
		if (checked[i]) {
			continue;
		}
		while (num <= N) {
			if (!checked[num]) {
				checked[num] = true;
				count++;
				if (count == K) {
					cout << num;
				}
			}			
			num += i;
		}
		if (count >= K) {
			break;
		}
	}
}