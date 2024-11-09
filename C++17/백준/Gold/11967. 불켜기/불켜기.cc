#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M;
vector<vector<queue<pair<int, int>>>> S;
vector<vector<bool>> isLight, visited;
int cnt = 1;
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };
queue<pair<int, int>> q;

void lightOn(int x, int y) {
	while (!S[x][y].empty()) {
		int lx = S[x][y].front().first;
		int ly = S[x][y].front().second;
		S[x][y].pop(); 
		if (!isLight[lx][ly]) {
			isLight[lx][ly] = true;
			cnt++;
		}
		if (!visited[lx][ly]) {
			for (int i = 0; i < 4; i++) {
				int mx = lx + dx[i];
				int my = ly + dy[i];
				if (mx < 1 || mx > N || my < 1 || my > N) continue;
				if (!visited[mx][my]) continue;
				q.push(make_pair(mx, my));
			}
		}
	}
}

void bfs() {
	q.push(make_pair(1, 1));

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		lightOn(x, y);
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx < 1 || mx > N || my < 1 || my > N) continue;
			if (visited[mx][my]) continue;
			if (!isLight[mx][my]) continue;
			visited[mx][my] = true;
			q.push(make_pair(mx, my));
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;

	S.assign(N + 1, vector<queue<pair<int, int>>>(N + 1));
	isLight.assign(N + 1, vector<bool>(N + 1));
	visited.assign(N + 1, vector<bool>(N + 1));

	for (int i = 0; i < M; i++) {
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		S[a][b].push(make_pair(c, d));
	}

	isLight[1][1] = true;
	visited[1][1] = true;
	bfs();

	cout << cnt;
}