#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

    vector<int> snacks;
    int M, N, result = 0;
	cin >> M >> N;

	for (int i = 0; i < N; i++) {
		int height;
		cin >> height;
		snacks.emplace_back(height);
	}
	sort(snacks.begin(), snacks.end());

    int start = 1;
    int end = snacks[N - 1];

    while (start <= end) {
        int mid = (start + end) / 2;

        long long cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (snacks[i] / mid == 0) {
                break;
            }
            cnt += snacks[i] / mid;
        }

        if (cnt < M) {
            end = mid - 1;
        }
        else {
            result = mid;
            start = mid + 1;
        }
    }

    cout << result;
}