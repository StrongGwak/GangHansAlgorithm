#include <iostream>
#include <vector>

int student[100001];
bool matched[100001];
bool visited[100001];
bool done[100001];
int unmatched;

int dfs(int current) {
	int end = 0;
	if (!visited[student[current]]) {
		visited[student[current]] = true;
		end = dfs(student[current]);
	}
	else if (visited[student[current]] && !done[student[current]]) {
		end = student[current];
	}

	if (end != 0) {
		if (current == end) {
			matched[end] = true;
		}

		if (!matched[end]) {
			matched[current] = true;
		}
	}

	if (!matched[current]) {
		unmatched++;
	}
	done[current] = true;
	return end;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(NULL);

	int T;
	std::cin >> T;
	for (int testcase = 0; testcase < T; testcase++) {
		unmatched = 0;
		int N;
		std::cin >> N;

		for (int i = 1; i <= N; i++) {
			int s;
			std::cin >> s;
			student[i] = s;
			matched[i] = false;
			visited[i] = false;
			done[i] = false;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}

		std::cout << unmatched << '\n';
	}
}