#include <iostream>
#include <vector>

using namespace std;

vector<int> v[100001];
int parent[100001];

void dfs(int cur, int p) {
	parent[cur] = p;
	for (int next : v[cur]) {
		if (next != p) {
			dfs(next, cur);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	for (int i = 1; i < N; i++) {
		int v1, v2;
		cin >> v1 >> v2;
		v[v1].emplace_back(v2);
		v[v2].emplace_back(v1);
	}

	dfs(1, 0);

	for (int i = 2; i <= N; i++) {
		cout << parent[i] << '\n';
	}
}