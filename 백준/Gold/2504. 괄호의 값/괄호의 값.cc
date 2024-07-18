#include <iostream>
#include <stack>
#include <string>

int main() {
	std::ios_base::sync_with_stdio(0);
	std::cin.tie(0);
	std::cout.tie(0);

	std::string word;
	std::cin >> word;

	std::stack<std::pair<char, int>> s;
	int result = 0;
	bool flag = false;
	for (int i = 0; i < word.size(); i++)
	{
		int current = 0;
		if (word[i] == '(')
		{
			s.push(std::make_pair('(', 0));
		}
		else if (word[i] == '[')
		{
			s.push(std::make_pair('[', 0));
		}
		else if (word[i] == ')')
		{
			if (s.empty() || s.top().first != '(')
			{
				flag = true;
				break;
			}
			else
			{
				current = s.top().second;
				s.pop();
				if (current == 0)
				{
					current = 2;
				}
				else
				{
					current *= 2;
				}
			}
		}
		else if (word[i] == ']')
		{
			if (s.empty() || s.top().first != '[')
			{
				flag = true;
				break;
			}
			else
			{
				current = s.top().second;
				s.pop();
				if (current == 0)
				{
					current = 3;
				}
				else
				{
					current *= 3;
				}
			}
		}
		if (s.empty())
		{
			result += current;
		}
		else
		{
			current += s.top().second;
			char topChar = s.top().first;
			s.pop();
			s.push(std::make_pair(topChar,current));
		}
	}
	if (!flag)
	{
		std::cout << result;
	}
	else
	{
		std::cout << 0;
	}
	
}