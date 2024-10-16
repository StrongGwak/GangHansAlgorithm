#include <iostream>
#include <queue>

int map[1001][1001] = { 0, };
int visited[1001][1001] = { false, };
int burn[1001][1001] = { false, };
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(NULL);

	int R, C;
	int result = -1;
	std::cin >> R >> C;

	std::queue < std::pair<std::pair<int, int>, int>> fire;
	std::queue < std::pair<std::pair<int, int>, int>> run;

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			char state;
			std::cin >> state;
			if (state == '#') {
				visited[i][j] = true;
				burn[i][j] = true;
			}
			else if (state == 'J') {
				visited[i][j] = true;
				run.push(std::make_pair(std::make_pair(i, j), 1));
			}
			else if (state == 'F') {
				burn[i][j] = true;
				map[i][j] = 1;
				fire.push(std::make_pair(std::make_pair(i, j), 1));
			}
		}
	}

	while (!fire.empty()) {
		int x = fire.front().first.first;
		int y = fire.front().first.second;
		int minute = fire.front().second;
		fire.pop();
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx >= 0 && mx < R && my >= 0 && my < C && !burn[mx][my]) {
				map[mx][my] = minute + 1;
				burn[mx][my] = true;
				fire.push(std::make_pair(std::make_pair(mx, my), minute + 1));
			}
		}
	}

	while (!run.empty()) {
		int x = run.front().first.first;
		int y = run.front().first.second;
		int minute = run.front().second;
		if (x == 0 || x == R - 1 || y == 0 || y == C - 1) {
			result = minute;
			break;
		}
		run.pop();
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx >= 0 && mx < R && my >= 0 && my < C && !visited[mx][my] && (minute + 1 < map[mx][my] || map[mx][my] == 0)) {
				visited[mx][my] = true;
				run.push(std::make_pair(std::make_pair(mx, my), minute + 1));
			}
		}
	}
	if (result != -1) {
		std::cout << result;
	}
	else {
		std::cout << "IMPOSSIBLE";
	}
}