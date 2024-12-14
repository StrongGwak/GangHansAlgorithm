#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;
	int result = 0;
	vector<pair<int, int> > v;
	for (int i = 0; i < N; i++)	{
		int ms, ds, me, de;
		cin >> ms >> ds >> me >> de;
		v.push_back(make_pair(ms * 100 + ds, me * 100 + de));
	}

	sort(v.begin(), v.end());

	int t = 301;
	int idx = 0;
	while (t < 1201) {
		int next = t;
		for (int i = idx; i < N; i++) {
			if (v[i].first <= t && v[i].second > next) {
				next = v[i].second;
				idx = i;
			}
			else if (v[i].first > t) {
				break;
			}
		}
		if (next == t) {
			cout << 0 << "\n";
			return 0;
		}
		t = next;
		result++;
	}

	cout << result;
}