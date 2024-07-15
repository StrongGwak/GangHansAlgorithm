#include <iostream>
#include <deque>

int main() {
	std::ios_base::sync_with_stdio(0);
	std::cin.tie(0);
	std::cout.tie(0);
	
	int n, l;
	std::cin >> n >> l;
	std::deque<std::pair<int, int>> deq;
	for (int i = 1; i <= n; i++)
	{
		int num;
		std::cin >> num;
		if (!deq.empty() && deq.front().first < i - l + 1)
		{
			deq.pop_front();
		}
		while (!deq.empty() && deq.back().second > num)
		{
			deq.pop_back();
		}
		deq.push_back(std::make_pair(i, num));
		std::cout << deq.front().second << ' ';
	}
}