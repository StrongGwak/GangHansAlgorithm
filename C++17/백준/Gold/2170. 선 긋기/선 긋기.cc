#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int N;
	int result = 0;
	cin >> N;

	vector<pair<int, int>> v;

	for (int i = 0; i < N; i++) {
		int s, e;
		cin >> s >> e;
		v.emplace_back(make_pair(s, e));
	}
	
	sort(v.begin(), v.end());

	int start = v[0].first;
	int end = v[0].second;
	
	for (int i = 1; i < N; i++) {
		if (v[i].first <= end) {
			if (end < v[i].second) {
				end = v[i].second;
			}
		}
		else {
			result += end - start;
			start = v[i].first;
			end = v[i].second;
		}
	}

	result += end - start;

	cout << result;
}