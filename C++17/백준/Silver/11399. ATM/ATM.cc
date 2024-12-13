#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;
	vector<int> line;
	int result = 0;
	int time = 0;

	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		line.emplace_back(num);
	}


	sort(line.begin(), line.end());

	for (int i = 0; i < N; i++) {
		time += line[i];
		result += time;
	}

	cout << result;
}