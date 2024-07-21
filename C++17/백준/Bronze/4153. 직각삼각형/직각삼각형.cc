#include <iostream>
#include <cmath>
#include <algorithm>

int main() {
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	while (true) {
		int nums[3] = { 0 };
		for (int i = 0; i < 3; i++) {
			std::cin >> nums[i];
		}
		std::sort(nums, nums + 3);
		
		if (nums[0] + nums[1] + nums[2] == 0) {
			break;
		}
		else if (pow(nums[0], 2) + pow(nums[1], 2) == pow(nums[2], 2)) {
			std::cout << "right" << '\n';
		}
		else {
			std::cout << "wrong" << '\n';
		}
	}
	
}