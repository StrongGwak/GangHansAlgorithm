#include <iostream>
#include <stack>
#include <string>

int main() {
	std::ios_base::sync_with_stdio(0);
	std::cin.tie(0);
	std::cout.tie(0);
	
	while (true)
	{
		std::string word;
		std::getline(std::cin, word);
		if (word == ".")
		{
			break;
		}
		std::stack<char> s;
		bool flag = false;
		for (int i = 0; i < word.size(); i++)
		{
			if (word[i] == '[' || word[i] == '(')
			{
				s.push(word[i]);
			}
			else if (word[i] == ']')
			{
				if (!s.empty() && s.top() == '[')
				{
					s.pop();
				}
				else
				{
					flag = true;
					break;
				}
			}
			else if (word[i] == ')')
			{
				if (!s.empty() && s.top() == '(')
				{
					s.pop();
				}
				else
				{
					flag = true;
					break;
				}
			}
		}
		if (!s.empty() || flag)
		{
			std::cout << "no" << '\n';
		}
		else
		{
			std::cout << "yes" << '\n';
		}
	}
}