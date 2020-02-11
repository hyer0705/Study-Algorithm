#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;

int solution(vector<int> priorities, int location) {
	
	int answer = 0;
	queue<int> docs;

	for (int i = 0; i < priorities.size(); ++i)
	{
		docs.push(i);
	}

	while (!docs.empty())
	{
		if (priorities[docs.front()] >= *max_element(priorities.begin(), priorities.end())) 
		{
			answer++;

			if (docs.front() == location) 
			{ 
				break; 
			}

			priorities[docs.front()] = 0;
		}
		else 
		{
			docs.push(docs.front());
		}

		docs.pop();
	}
	return answer;
}

int main()
{
	vector<int> priorities = { 1, 1, 9, 1, 1, 1 };
	int location = 0;

	cout << solution(priorities, location);
}