#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Node {
	int x;
	int y;
	int move;
};

int N;
vector<vector<int>> map;
vector<vector<int>> visited;
vector<queue<Node>> bq;
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };
int land = 0;
int result = 10001;

void landcheck(int x, int y) {
	map[x][y] += land;
	visited[x][y] = map[x][y];
	for (int i = 0; i < 4; i++) {
		int mx = x + dx[i];
		int my = y + dy[i];
		if (mx < 0 || mx >= N || my < 0 || my >= N) {
			continue;
		}
		if (visited[mx][my] != 0) {
			continue;
		}
		if (map[mx][my] == 0) {
			visited[mx][my] = map[x][y];
			Node n = { mx, my, 1 };
			bq[land + 1].push(n);
			continue;
		}
		landcheck(mx, my);
	}

}

void bfs(int l) {
	while (!bq[l].empty()) {
		Node n = bq[l].front();
		bq[l].pop();
		for (int i = 0; i < 4; i++) {
			int mx = n.x + dx[i];
			int my = n.y + dy[i];
			if (mx < 0 || mx >= N || my < 0 || my >= N) {
				continue;
			}
			if (visited[mx][my] == l || map[mx][my] == l) {
				continue;
			}
			if (map[mx][my] != 0 && map[mx][my] != l) {
				if (result > n.move) {
					result = n.move;
					continue;
				}
			}
			visited[mx][my] = l;
			Node bridge = { mx, my, n.move + 1 };
			bq[l].push(bridge);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;
	vector<int> tempM(N);
	map.assign(N, tempM);
	visited.assign(N, tempM);

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
		}
	}

	queue<Node> tmp;
	bq.emplace_back(tmp);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visited[i][j] == 0 && map[i][j] != 0) {
				bq.emplace_back(tmp);
				landcheck(i, j);
				land++;
			}
		}
	}

	int lands = bq.size() - 1;
	while (lands > 0) {
		bfs(lands--);
	}

	cout << result << '\n';
}