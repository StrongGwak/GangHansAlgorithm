#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<vector<int>> map;
vector<vector<vector<bool>>> visited;
int N, M, K;
int dx[4] = { 1, -1 ,0, 0 };
int dy[4] = { 0, 0, 1, -1 };

struct Node {
	int x;
	int y;
	int broke;
	int move;
};

int bfs(int x, int y) {
	queue<Node> q;
	q.push(Node{ x, y, K, 1});
	visited[K][x][y] = true;

	while (!q.empty()) {
		Node n = q.front();
		q.pop();
		if (n.x == N - 1 && n.y == M - 1) {
			return n.move;
		}
		for (int i = 0; i < 4; i++) {
			int mx = n.x + dx[i];
			int my = n.y + dy[i];
			if (mx < 0 || mx >= N || my < 0 || my >= M) continue;
			if (visited[n.broke][mx][my]) continue;
			if (map[mx][my] == 0) {
				visited[n.broke][mx][my] = true;
				q.push(Node{ mx, my, n.broke, n.move + 1 });
			}
			else if (map[mx][my] == 1 && n.broke > 0) {
				if (visited[n.broke - 1][mx][my]) continue;
				visited[n.broke - 1][mx][my] = true;
				q.push(Node{ mx, my, n.broke - 1, n.move + 1 });
			}
		}
	}

	return -1;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M >> K;
	map.resize(N, vector<int>(M));
	visited.assign(K + 1, vector<vector<bool>>(N, vector<bool>(M, false)));

	for (int i = 0; i < N; i++) {
		string line;
		cin >> line;
		for (int j = 0; j < M; j++) {
			map[i][j] = line[j] - '0';
		}
	}

	cout << bfs(0, 0);
}