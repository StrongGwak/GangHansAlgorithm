#include <iostream>
#include <stack>
#include <string>

int main() {
	std::ios_base::sync_with_stdio(0);
	std::cin.tie(0);
	std::cout.tie(0);

	std::string word;
	std::cin >> word;

	std::stack<int> s;
	int laser = 0;
	int result = 0;
	for (int i = 0; i < word.size(); i++)
	{
		if (word[i] == '(')
		{
			s.push(0);
		}
		else
		{
			laser = s.top();
			s.pop();
			if (!s.empty())
			{
				int value = 0;
				if (laser == 0)
				{
					value = s.top() + 1;
				}
				else
				{
					result += laser + 1;
					value = s.top() + laser;
					
				}
				s.pop();
				s.push(value);
			}
			else
			{
				if (laser != 0)
				{
					result += laser + 1;
				}
			}
		}
	}
	std::cout << result;
	
}