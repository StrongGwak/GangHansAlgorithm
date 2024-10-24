#include <iostream>
#include <vector>

using namespace std;

int N, S, result = 0;
vector<int> v;
vector<int> num;

void combination(int cnt, int start, int sum) {
	if (cnt != 0 && sum == S) {
		result++;
	}

	for (int i = start; i < N; i++) {
		v[cnt] = num[i];
		combination(cnt + 1, i + 1, sum + num[i]);
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

	combination(0, 0, 0);

	cout << result;
}