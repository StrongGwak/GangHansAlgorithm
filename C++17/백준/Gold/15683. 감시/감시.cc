#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M;
int map[9][9];
int temp[9][9];
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, 1, 0, -1 };
vector<pair<int, int>> cctv;

void watch(int x, int y, int r) {
	r %= 4;

	while (true) {
		x += dx[r];
		y += dy[r];
		if (x < 0 || x >= N || y < 0 || y >= M || temp[x][y] == 6) {
			return;
		}
		if (temp[x][y] == 0) {
			temp[x][y] = 7;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;

	int result = N * M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
			if (map[i][j] != 0 && map[i][j] != 6) {
				cctv.push_back(make_pair(i, j));
			}
		}
	}

	int f = 4;
	for (int i = 1; i < cctv.size(); i++) {
		f *= 4;
	}

	for (int i = 0; i < f; i++) {
		for (int a = 0; a < N; a++) {
			for (int b = 0; b < M; b++) {
				temp[a][b] = map[a][b];
			}
		}

		int b = i;

		for (int j = 0; j < cctv.size(); j++) {
			int d = b % 4;
			b /= 4;
			int x = cctv[j].first;
			int y = cctv[j].second;
			int t = map[x][y];
			if (t == 1) {
				watch(x, y, d);
			}
			else if (t == 2) {
				watch(x, y, d);
				watch(x, y, d + 2);
			}
			else if (t == 3) {
				watch(x, y, d);
				watch(x, y, d + 1);
			}
			else if (t == 4) {
				watch(x, y, d);
				watch(x, y, d + 1);
				watch(x, y, d + 2);
			}
			else{
				watch(x, y, d);
				watch(x, y, d + 1);
				watch(x, y, d + 2);
				watch(x, y, d + 3);
			}
		}

		int v = 0;
		for (int a = 0; a < N; a++) {
			for (int b = 0; b < M; b++) {
				if (temp[a][b] == 0) {
					v++;
				}
			}
		}
		result = min(result, v);
	}

	cout << result;
}