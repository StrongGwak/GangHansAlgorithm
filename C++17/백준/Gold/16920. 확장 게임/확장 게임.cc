#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Node {
	int x;
	int y;
	int move;
};

int N, M, P;
char map[1001][1001];
vector<queue<Node>> q;
queue<Node> nq;
bool cp[10] = { false, };
int m[10], castles[10];
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };
int cnt = 0;

void bfs() {
	while (cnt != 0) {
		for (int i = 1; i <= P; i++) {
			bool flag = false;
			if (cp[i]) {
				continue;
			}
			while (!q[i].empty()) {
				flag = true;
				Node n = q[i].front();
				q[i].pop();
				if (n.move == m[i]) {
					nq.push(Node{ n.x, n.y, n.move });
					continue;
				}
				for (int k = 0; k < 4; k++) {
					int mx = n.x + dx[k];
					int my = n.y + dy[k];
					if (mx < 0 || mx >= N || my < 0 || my >= M) continue;
					if (map[mx][my] != '.') continue;
					map[mx][my] = i;
					q[i].push(Node{ mx, my, n.move + 1 });
					castles[i]++;
				}
			}
			while (!nq.empty()) {
				Node n = nq.front();
				n.move = 0;
				q[i].push(n);
				nq.pop();
			}
			if (!flag) {
				cp[i] = true;
				cnt--;
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M >> P;
	
	cnt = P;
	q.emplace_back();
	for (int i = 1; i <= P; i++) {
		cin >> m[i];
		q.emplace_back();
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
			if (map[i][j] != '.' && map[i][j] != '#') {
				q[map[i][j] - '0'].push(Node{i, j});
				castles[map[i][j] - '0']++;
			}
		}
	}

	bfs();

	for (int i = 1; i <= P; i++) {
		cout << castles[i] << " ";
	}
}