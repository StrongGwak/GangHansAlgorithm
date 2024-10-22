#include <iostream>

using namespace std;

int N, M;
int num[9];
bool visited[9];

void permutation(int cnt) {
	if (cnt == M) {
		for (int i = 0; i < cnt; i++) {
			cout << num[i] << " ";
		}
		cout << '\n';
		return;
	}

	for (int i = 1; i <= N; i++) {
		if (!visited[i]) {
			visited[i] = true;
			num[cnt] = i;
			permutation(cnt + 1);
			visited[i] = false;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin >> N >> M;

	permutation(0);
}