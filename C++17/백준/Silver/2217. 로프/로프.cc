#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;
	vector<int> v;
	int result = 0;

	for (int i = 0; i < N; i++) {
		int rope;
		cin >> rope;
		v.emplace_back(rope);
	}
	sort(v.begin(), v.end());

	for (int i = 0; i < v.size(); i++) {
		int rope = v[i] * (N - i);
		result = max(result, rope);
	}

	cout << result;
}