#include <iostream>
#include <vector>
using namespace std;

int N;
bool visited[100001];
vector<int> nodes[100001];
int p[100001];

void dfs(int idx) {
	visited[idx] = true;
	for (int i = 0; i < nodes[idx].size(); i++) {
		if (!visited[nodes[idx][i]]) {
			p[nodes[idx][i]] = idx;
			dfs(nodes[idx][i]);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;

	for (int i = 1; i < N; i++) {
		int x, y;
		cin >> x >> y;
		nodes[x].emplace_back(y);
		nodes[y].emplace_back(x);
	}
	
	dfs(1);

	for (int i = 2; i <= N; i++) {
		cout << p[i] << '\n';
	}
}