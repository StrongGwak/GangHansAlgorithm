#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> adj[32001];
int deg[32001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M;
	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int front, back;
		cin >> front >> back;
		adj[front].emplace_back(back);
		deg[back]++;
	}

	queue<int> q;
	for (int i = 1; i <= N; i++) {
		if (deg[i] == 0) {
			q.push(i);
		}
	}

	while (!q.empty()) {
		int num = q.front();
		q.pop();
		cout << num << " ";

		for (int next : adj[num]) {
			deg[next]--;
			if (deg[next] == 0) {
				q.push(next);
			}
		}
	}
}