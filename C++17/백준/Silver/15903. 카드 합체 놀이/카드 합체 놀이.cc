#include <iostream>
#include <queue>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	int N, M;
	long long result = 0;
	cin >> N >> M;
	
	priority_queue<long long, vector<long long>, greater<long long>> pq;

	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		pq.push(num);
	}

	for (int i = 0; i < M; i++) {
		long long num1 = pq.top();
		pq.pop();
		long long num2 = pq.top();
		pq.pop();

		pq.push(num1 + num2);
		pq.push(num1 + num2);
	}

	while (!pq.empty()) {
		result += pq.top();
		pq.pop();
	}

	cout << result;
}