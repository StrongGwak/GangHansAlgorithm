#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, m;
int map[500][500];
bool visited[500][500];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

int dfs(int x, int y, int value)
{
	int sum = 0;
	for (int i = 0; i < 4; i++)
	{
		int mx = x + dx[i];
		int my = y + dy[i];
		if (mx >= 0 && mx < n && my >= 0 && my < m){
			if(!visited[mx][my] && map[mx][my] == 1)
			{
				visited[mx][my] = true;
				sum += dfs(mx, my, value);
			}	
		}
	}
	return sum + value;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	int result = 0, max = 0;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> map[i][j];
		}
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (!visited[i][j] && map[i][j] == 1)
			{
				result++;
				visited[i][j] = true;
				int value = dfs(i, j, 1);
				if (max < value)
				{
					max = value;
				}
			}
		}
	}
	cout << result << '\n' << max;
	
}