#include <iostream>
#include <vector>
#include <queue>

int dx[6] = {0, 0, 1, -1, 0, 0};
int dy[6] = {0, 0, 0, 0, 1, -1};
int dz[6] = {1, -1, 0, 0, 0, 0};

struct Node {
	int x, y, z, move;
};

int bfs(int startX, int startY, int startZ, int endX, int endY, int endZ, std::vector<std::vector<std::vector<bool>>> map) {
	int L = map.size();
	int R = map[0].size();
	int C = map[0][0].size();
	std::queue<Node> q;
	Node n = {startX, startY, startZ, 0};
	q.push(n);
	
	while (!q.empty()) {
		int x = q.front().x;
		int y = q.front().y;
		int z = q.front().z;
		int move = q.front().move;
		q.pop();
		for (int i = 0; i < 6; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			int mz = z + dz[i];
			if (mx >= 0 && mx < R && my >= 0 && my < C && mz >= 0 && mz < L) {
				if (mx == endX && my == endY && mz == endZ) {
					return move + 1;
				}
				if (!map[mz][mx][my]) {
					map[mz][mx][my] = true;
					n = {mx, my, mz, move + 1};
					q.push(n);
				}
			}
		}
	}
	return 0;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(NULL);

	while (true) {
		int L, R, C, startZ, startX, startY, endZ, endX, endY;
		std::cin >> L >> R >> C;

		if (L == 0 && R == 0 && C == 0) {
			break;
		}

		std::vector<std::vector<std::vector<bool>>> map;
		for (int i = 0; i < L; i++) {
			std::vector<std::vector<bool>> tempRow;
			for (int j = 0; j < R; j++) {
				std::vector<bool> tempCol;
				char info;
				for (int k = 0; k < C; k++) {
					std::cin >> info;
					if (info != '.') {
						tempCol.emplace_back(true);
						if (info == 'S') {
							startZ = i;
							startX = j;
							startY = k;
						} 
						else if (info == 'E') {
							endZ = i;
							endX = j;
							endY = k;
						}
					}
					else {
						tempCol.emplace_back(false);
					}
				}
				tempRow.emplace_back(tempCol);
			}
			map.emplace_back(tempRow);
		}
		
		int result = bfs(startX, startY, startZ, endX, endY, endZ, map);
		if (result == 0) {
			std::cout << "Trapped!" << '\n';
		}
		else {
			std::cout << "Escaped in " << result << " minute(s)." << '\n';
		}
		
	}
	
}