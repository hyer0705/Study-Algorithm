#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <stack>

using namespace std;

int solution(string arrangement) {
	
	int answer = 0;
	char prev = ' ';
	stack<int> stick;

	for (char c : arrangement) 
	{
		if (c == ')')
		{
			stick.pop();
			answer += prev == '(' ? stick.size() : 1;
		}
		else 
		{
			stick.push(c);
		}

		prev = c;
	}
	return answer;
}

int main()
{
	string arrangement = "()(((()())(())()))(())";
	cout << solution(arrangement);
}