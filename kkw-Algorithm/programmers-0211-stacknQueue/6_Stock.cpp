#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <stack>

using namespace std;

vector<int> solution(vector<int> prices) {

	vector<int> answer;
	stack<int> index;

	for (int i = 0; i < prices.size(); ++i)
	{
		answer.push_back(prices.size() - i - 1);

		while(!index.empty() && prices[index.top()] > prices[i])
		{
			answer[index.top()] = (i - index.top());
			index.pop();
		}

		index.push(i);
	}
	
	return answer;
}

int main()
{
	vector<int> prices = { 1, 2, 3, 2, 3 };
	
	for (int i : solution(prices)) {

		cout << i;
	}
}