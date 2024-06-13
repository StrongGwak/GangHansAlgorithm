#include <iostream>
#include <vector>
#include <algorithm>

int main() {
	int n = 0;
	int x = 0;
	std::vector<int> nums;
	int result = 0;
	std::cin >> n;
	for (int i = 0; i < n; i++) 
	{
		int num = 0;
		std::cin >> num;
		nums.emplace_back(num);
	}
	std::cin >> x;
	sort(nums.begin(), nums.end());

	for (int i = 0; i < n - 1; i++) 
	{
		for (int j = i + 1; j < n; j++) 
		{
			if (nums[i] + nums[j] == x) {
				result++;
			}
			else if (nums[i] + nums[j] > x) {
				break;
			}
		}
	}

	std::cout << result;
}