#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int N, result = 0;
	cin >> N;
	
	vector<int> m, p;

	if (N == 1) {
		int num;
		cin >> num;
		cout << num;
	}
	else {
		for (int i = 0; i < N; i++) {
			int num;
			cin >> num;
			if (num > 0) {
				p.emplace_back(num);
			}
			else {
				m.emplace_back(num);
			}
		}
		sort(p.begin(), p.end());
		sort(m.begin(), m.end());

		for (int i = p.size() - 1; i >= 0; i--) {
			if (i != 0 && p[i] < p[i] * p[i - 1]) {
				result += p[i] * p[i - 1];
				i--;
			}
			else {
				result += p[i];
			}
		}

		for (int i = 0; i < m.size(); i++) {
			if (i == m.size() - 1) {
				result += m[i];
				break;
			}
			result += m[i] * m[i + 1];
			i++;
		}

		cout << result;
	}
	
}