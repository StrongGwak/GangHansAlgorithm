#include <iostream>
#include <queue>

using namespace std;

int relation[101][101];
bool visited[101][101];
int n, start, last, m;

int bfs() {
	queue<pair<int, int>> q;
	q.push(make_pair(start, 0));

	while (!q.empty()) {
		int s = q.front().first;
		int r = q.front().second;
		if (s == last) {
			return r;
		}
		q.pop();
		for (int i = 1; i <= n; i++) {
			if (relation[s][i] == 1 && !visited[s][i]) {
				visited[s][i] = true;
				visited[i][s] = true;
				q.push(make_pair(i, r + 1));
			}
		}
	}
	return -1;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> start >> last >> m;

	for (int i = 0; i < m; i++) {
		int x;
		int y;
		cin >> x >> y;
		relation[x][y] = 1;
		relation[y][x] = 1;
	}

	cout << bfs();
}