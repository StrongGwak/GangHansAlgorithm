#include <iostream>
#include <vector>

using namespace std;

int m[101] = { 0, };
bool on[101] = { false, };

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int N, K;
	int result = 0;
	vector<int> v;

	cin >> N >> K;

	for (int i = 0; i < K; i++) {
		int num;
		cin >> num;
		v.emplace_back(num);
	}

	int tap = 0;

	for (int i = 0; i < K; i++) {
		if (on[v[i]]) {
			continue;
		}
		if (tap < N) {
			m[tap] = v[i];
			on[v[i]] = true;
			tap++;
		}
		else {
			int index = -1;
			int order = -1;
			for (int j = 0; j < N; j++) {
				int tmp = 0;
				for (int a = i + 1; a < K; a++) {
					if (v[a] == m[j]) {
						break;
					}
					tmp++;
				}
				if (tmp > order) {
					index = j;
					order = tmp;
				}
			}
			on[m[index]] = false;
			on[v[i]] = true;
			m[index] = v[i];
			result++;
		}
	}
	cout << result;

}