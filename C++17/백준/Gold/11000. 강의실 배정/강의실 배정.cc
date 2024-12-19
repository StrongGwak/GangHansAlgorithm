#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int N;
	cin >> N;
	
	vector<pair<int, int>> rooms;
	priority_queue<int, vector<int>, greater<int>> pq;

	for (int i = 0; i < N; i++) {
		int s, e;
		cin >> s >> e;
		rooms.emplace_back(make_pair(s, e));
	}

	sort(rooms.begin(), rooms.end());

	for (int i = 0; i < N; i++) {
		pq.push(rooms[i].second);
		if (pq.top() <= rooms[i].first) {
			pq.pop();
		}
	}

	cout << pq.size();
}