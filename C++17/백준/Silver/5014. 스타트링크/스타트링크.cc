#include <iostream>
#include <vector>
#include <queue>

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(NULL);

	int F, S, G, U, D, result = -1;
	std::cin >> F >> S >> G >> U >> D;

	std::vector<bool> visited;
	for (int i = 0; i <= F; i++) {
		visited.emplace_back(false);
	}

	std::queue<std::pair<int, int>> q;
	q.push(std::make_pair(S, 0));
	visited[S] = true;
	if (S == G) {
		result = 0;
	}

	else {
		while (!q.empty()) {
			int current = q.front().first;
			int move = q.front().second;
			q.pop();

			int up = current + U;
			int down = current - D;
			if (up == G || down == G) {
				result = move + 1;
				break;
			}
			if (up <= F && !visited[up]) {
				visited[up] = true;
				q.push(std::make_pair(up, move + 1));
			}
			if (down >= 1 && !visited[down]) {
				visited[down] = true;
				q.push(std::make_pair(down, move + 1));
			}
		}
	}
	
	if (result == -1) {
		std::cout << "use the stairs";
	}
	else {
		std::cout << result;
	}

}