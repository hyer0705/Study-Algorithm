#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <stack>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {

	vector<int> answer;

	stack<int> time;

	for (int i = progresses.size() - 1; i >= 0; i--)
	{
		time.push((100 - progresses[i]) / speeds[i]);
	}

	int ans = 0;
	int min = time.top();

	while (!time.empty())
	{
		if (time.top() <= min)
		{
			ans++;
			time.pop();
		}
		else
		{
			answer.push_back(ans);
			ans = 0;
			min = time.top();
		}
	}

	answer.push_back(ans);

	return answer;
}


int main()
{
	vector<int> progresses = { 93,30,55 };
	vector<int> speeds = { 1,30,5 };

	for (int i : solution(progresses, speeds)) {

		cout << i << " ";
	}

}