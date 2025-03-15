#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<int> adj[1001];
bool visited[1001];

void dfs(int start) {
	if (visited[start]) {
		return;
	}
	visited[start] = true;
	cout << start << " ";
	for (int next : adj[start]) {
		if (!visited[next]) {
			dfs(next);
		}
	}
}

void bfs(int start) {
	queue<int> q;
	q.push(start);
	visited[start] = true;

	while (!q.empty()) {
		int v = q.front();
		cout << v << " ";
		q.pop();

		for (int next : adj[v]) {
			if (!visited[next]) {
				q.push(next);
				visited[next] = true;
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N = 0;
	int M = 0;
	int V = 0;
	cin >> N >> M >> V;

	for (int i = 0; i < M; i++) {
		int from, to;
		cin >> from >> to;
		adj[from].emplace_back(to);
		adj[to].emplace_back(from);
	}

	for (int i = 1; i <= N; i++) {
		sort(adj[i].begin(), adj[i].end());
	}

	dfs(V);
	fill(visited, visited + 1001, false);
	cout << '\n';
	bfs(V);
}