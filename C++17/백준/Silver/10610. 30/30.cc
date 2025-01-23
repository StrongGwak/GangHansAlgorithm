#include <iostream>

using namespace std;

int nums[10];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	string N;
	cin >> N;
	int sum = 0;
	for (int i = 0; i < N.size(); i++) {
		int num = N[i] - '0';
		sum += num;
		nums[num]++;
	}

	if (sum % 3 != 0) {
		cout << -1;
	}
	else if (nums[0] == 0)
	{
		cout << -1;
	}
	else 
	{
		for (int i = 9; i >= 0; i--) {
			if (nums[i] != 0) {
				for (int j = 0; j < nums[i]; j++) {
					cout << i;
				}
			}
		}
	}
}