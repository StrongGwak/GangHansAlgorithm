#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct knight
{
	int x;
	int y;
	int move;
};

int dx[8] = {-2, -2, -1, -1, 1, 1, 2, 2};
int dy[8] = {1, -1, 2, -2, 2, -2, 1, -1};
vector<vector<bool>> visited;
int m, startX, startY, endX, endY;

int bfs()
{
	if (startX == endX && startY == endY)
	{
		return 0;
	}
	queue<knight> q;
	knight k = {startX, startY, 0};	
	visited[startX][startY] = true;
	q.emplace(k);
	while (!q.empty())
	{
		knight node = q.front();
		q.pop();
		for (int i = 0; i < 8; i++)
		{
			int mx = node.x + dx[i];
			int my = node.y + dy[i];
			if (mx >= 0 && mx < m && my >= 0 && my < m && visited[mx][my] != 1)
			{
				if (mx == endX && my == endY)
				{
					return node.move + 1;
				}
				visited[mx][my] = 1;
				knight temp = {mx, my, node.move + 1};
				q.emplace(temp);
			}
		}
	}
	return -1;
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	int t;
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		cin >> m >> startX >> startY >> endX >> endY;
		visited.clear();
		for (int j = 0; j < m; j++)
		{
			vector<bool> tmpv;
			for (int k = 0; k < m; k++)
			{
				tmpv.emplace_back(false);
			}
			visited.emplace_back(tmpv);
		}
		cout << bfs() << '\n';
	}
}