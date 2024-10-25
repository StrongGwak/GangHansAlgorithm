#include <iostream>
#include <vector>

using namespace std;

vector<int> num;
int N, M;

void permutation(int cnt, int start) {
	if (cnt == M) {
		for (int i = 0; i < cnt; i++) {
			cout << num[i] << " ";
		}
		cout << '\n';
		return;
	}

	for (int i = start; i <= N; i++) {
		num[cnt] = i;
		permutation(cnt + 1, i);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;

	num.assign(M, 0);

	permutation(0, 1);
}