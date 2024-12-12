#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;

bool cmp(int num1, int num2) {
	return num1 > num2;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;
	vector<int> a, b;
	int result = 0;

	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		a.emplace_back(num);
	}

	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		b.emplace_back(num);
	}

	sort(a.begin(), a.end());
	sort(b.begin(), b.end(), cmp);

	for (int i = 0; i < N; i++) {
		result += a[i] * b[i];
	}

	cout << result;
}