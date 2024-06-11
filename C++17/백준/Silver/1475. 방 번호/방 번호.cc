#include <iostream>
#include <cmath>

int main() {
	int n = 0;
	int nums[10] = { 0 };
	int six = 0;
	int result = 0;
	std::cin >> n;
	while (n > 0) {
		nums[n % 10]++;
		n /= 10;
	}
	nums[6] = ceil((nums[6] + nums[9]) / 2.0);
	for (int i = 0; i < 9; i++) {
		if (nums[i] > result)
		{
			result = nums[i];
		}
	}

	std::cout << result;
}