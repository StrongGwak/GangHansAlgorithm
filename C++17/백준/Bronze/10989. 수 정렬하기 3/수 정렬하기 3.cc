#include <iostream>

int main() {
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int num;
	int nums[10001] = { 0 };
	std::cin >> num;
	for (int i = 0; i < num; i++) {
		int n;
		std::cin >> n;
		nums[n]++;
	}

	for (int i = 1; i < 10001; i++) {
		if (nums[i] != 0) {
			for (int j = 0; j < nums[i]; j++) {
				std::cout << i << '\n';
			}
		}
	}
}