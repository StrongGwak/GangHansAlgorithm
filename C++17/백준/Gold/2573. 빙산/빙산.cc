#include <iostream>
#include <vector>
#include <queue>

int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };
int N, M;
int map[301][301] = { 0, };
bool visited[301][301] = { false, };

void bfs(int startX, int startY) {
	int melt[301][301] = { 0, };
	std::queue<std::pair<int, int>> q;
	q.push(std::make_pair(startX, startY));
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx >= 0 && mx < N && my >= 0 && my < M) {
				if (map[mx][my] == 0) {
					visited[mx][my] = true;
					melt[x][y]++;
				}
				else if (map[mx][my] != 0 && !visited[mx][my]) {
					visited[mx][my] = true;
					q.push(std::make_pair(mx, my));
				}
			}
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (melt[i][j] != 0) {
				if (map[i][j] < melt[i][j]) {
					map[i][j] = 0;
				}
				else {
					map[i][j] -= melt[i][j];
				}
				melt[i][j] = 0;
			}
		}
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			int num;
			std::cin >> num;
			map[i][j] = num;
		}
	}

	int time = 0;
	int lands = 0;

	while (lands < 2) {
		lands = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = false;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					bfs(i, j);
					lands++;
				}
			}
		}

		if (lands == 0) {
			std::cout << 0;
			break;
		}
		else if (lands >= 2) {
			std::cout << time;
			break;
		}
		time++;
	}
}