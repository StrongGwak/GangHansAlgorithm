#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, S, result = 0;
vector<int> v;
vector<int> num;

void combination(int cnt, int start) {
	if (cnt == S) {
		for (int i = 0; i < S; i++) {
			cout << v[i] << " ";
		}
		cout << '\n';
	}


	for (int i = start; i < N; i++) {
		v[cnt] = num[i];
		combination(cnt + 1, i + 1);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> S;
	
	for (int i = 0; i < N; i++) {
		int n;
		cin >> n;
		v.emplace_back(0);
		num.emplace_back(n);
	}

	sort(num.begin(), num.end());

	combination(0, 0);
}