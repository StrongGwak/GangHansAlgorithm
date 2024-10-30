#include <iostream>
#include <vector>
#include <deque>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, K, result = 0;
	cin >> N >> K;

	vector<int> visited(200001, 0);
	vector<int> l(200001, 0);

	deque <pair<int, int>> q;
	q.push_front(make_pair(N, 0));
	visited[N]++;
	l[N] = N;

	while (!q.empty()) {
		int current = q.front().first;
		int second = q.front().second;
		q.pop_front();
		if (current == K) {
			result = second;
			break;
		}
		int back = current - 1;
		int foward = current + 1;
		int teleport = current * 2;
		if (teleport <= 200000 && !visited[teleport]) {
			visited[teleport]++;
			l[teleport] = current;
			q.push_front(make_pair(teleport, second + 1));
		}
		if (back >= 0 && !visited[back]) {
			visited[back]++;
			l[back] = current;
			q.push_back(make_pair(back, second + 1));
		}
		if (foward <= K && !visited[foward]) {
			visited[foward]++;
			l[foward] = current;
			q.push_back(make_pair(foward, second + 1));
		}
	}

	cout << result << '\n';
	vector<int> loute;
	loute.emplace_back(K);
	while (N != K) {
		loute.emplace_back(l[K]);
		K = l[K];
	}
	for (int i = loute.size() - 1; i >= 0; i--) {
		cout << loute[i] << " ";
	}
}