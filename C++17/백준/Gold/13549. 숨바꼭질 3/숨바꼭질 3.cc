#include <iostream>
#include <vector>
#include <deque>

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(NULL);

	int N, K;
	std::cin >> N >> K;

	std::vector<int> visited(200001, 0);
	
	std::deque <std::pair<int, int>> q;
	q.push_front(std::make_pair(N, 0));
	visited[N] = true;

	while (!q.empty()) {
		int current = q.front().first;
		int second = q.front().second;
		q.pop_front();
		if (current == K) {
			std::cout << second;
			break;
		}
		int back = current - 1;
		int foward = current + 1;
		int teleport = current * 2;
		if (teleport <= 200000 && !visited[teleport]) {
			visited[teleport]++;
			q.push_front(std::make_pair(teleport, second));
		}
		if (back >= 0 && !visited[back]) {
			visited[back]++;
			q.push_back(std::make_pair(back, second + 1));
		}
		if (foward <= K && !visited[foward]) {
			visited[foward]++;
			q.push_back(std::make_pair(foward, second + 1));
		}
	}
}