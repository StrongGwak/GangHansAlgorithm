#include <iostream>
#include <vector>
#include <queue>

struct node {
	int x, y, second;
};

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(NULL);

	int T;
	std::cin >> T;
	for (int testcase = 0; testcase < T; testcase++) {
		int w, h;
		std::cin >> w >> h;
		std::vector<std::vector<int>> fireMap;
		std::vector<std::vector<bool>> visited;
		std::queue<node> fire;
		std::queue<node> p;
		for (int i = 0; i < h; i++) {
			std::vector<int> tempMap;
			std::vector<bool> tempVisit;
			for (int j = 0; j < w; j++) {
				char n;
				std::cin >> n;
				if (n == '#') {
					tempMap.emplace_back(-1);
					tempVisit.emplace_back(false);
				}
				else if (n == '.') {
					tempMap.emplace_back(1001);
					tempVisit.emplace_back(false);
				}
				else if (n == '*') {
					tempMap.emplace_back(0);
					node n = { i, j, 0 };
					fire.push(n);
					tempVisit.emplace_back(false);
				}
				else if (n == '@') {
					tempMap.emplace_back(1001);
					node n = { i, j, 0 };
					p.push(n);
					tempVisit.emplace_back(true);
				}
			}
			fireMap.emplace_back(tempMap);
			visited.emplace_back(tempVisit);
		}

		int dx[4] = { 1,-1, 0, 0 };
		int dy[4] = { 0, 0, 1, -1 };
		int result = -1;

		while (!fire.empty()) {
			int x = fire.front().x;
			int y = fire.front().y;
			int second = fire.front().second;
			fire.pop();
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if (mx >= 0 && mx < h && my >= 0 && my < w && fireMap[mx][my] == 1001) {
					fireMap[mx][my] = second + 1;
					node n = { mx, my, second + 1};
					fire.push(n);
				}
			}
		}

		/*for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				std::cout << fireMap[i][j] << " ";
			}
			std::cout << '\n';
		}*/

		while (!p.empty()) {
			int x = p.front().x;
			int y = p.front().y;
			int second = p.front().second;
			if (x == 0 || x == h - 1 || y == 0 || y == w - 1) {
				result = second + 1;
				break;
			}
			p.pop();
			for (int i = 0; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if (mx >= 0 && mx < h && my >= 0 && my < w && fireMap[mx][my] > second + 1 && !visited[mx][my]) {
					visited[mx][my] = true;
					node n = { mx, my, second + 1 };
					p.push(n);
				}
			}
			
		}

		if (result != -1) {
			std::cout << result << '\n';
		}
		else {
			std::cout << "IMPOSSIBLE" << '\n';
		}
	}
}