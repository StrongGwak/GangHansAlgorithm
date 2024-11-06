#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int p[5][5];
bool visited[5][5];
int result = 0;
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

struct Node {
	int x;
	int y;
};

bool bfs(int idx) {
	bool check[5][5] = { {false, }, };
	queue<Node> q;
	q.push(Node{ idx / 5, idx % 5});
	check[q.front().x][q.front().y] = true;
	int cnt = 0;

	while (!q.empty()) {
		Node n = q.front();
		cnt++;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int mx = n.x + dx[i];
			int my = n.y + dy[i];
			if (mx < 0 || mx >= 5 || my < 0 || my >= 5) continue;
			if (check[mx][my] || !visited[mx][my]) continue;
			check[mx][my] = true;
			q.push(Node{ mx, my});
		}
	}
	if (cnt != 7) {
		return false;
	}
	else {
		return true;
	}
}

void combination(int idx, int cnt, int sum) {
	if (cnt == 7) {
		if (sum >= 4) {
			if (bfs(idx)) {
				result++;
			}
		}
		return;
	}

	for (int i = idx; i < 25; i++) {
		if (!visited[i / 5][i % 5]) {
			visited[i / 5][i % 5] = true;
			combination(i, cnt + 1, sum + p[i / 5][i % 5]);
			visited[i / 5][i % 5] = false;
		}
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	for (int i = 0; i < 5; i++) {
		string w;
		cin >> w;
		for (int j = 0; j < 5; j++) {
			if (w[j] == 'S') {
				p[i][j] = 1;
			}
		}
	}
	
	combination(0, 0, 0);

	cout << result;
}