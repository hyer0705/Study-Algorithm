#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <stack>

// 1번빼고 다 시간초과 돼서 수정해야 함
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {

	vector<int> answer;
	stack<int> done;

	int published = 0;

	while (published < progresses.size())
	{
		for (int i = progresses.size() - 1; i >= 0; i--)
		{
			progresses[i] += speeds[i];

			if (progresses[i] >= 100)
			{
				progresses[i] = speeds[i] = 0;
				done.push(i);
			}
		}

		int ans = 0;
		int done_size = done.size();

		for (int i = 0; i < done_size; i++)
		{

			if (done.top() <= published)
			{
				done.pop();
				++ans;
				++published;

			}
		}

		if (ans > 0)
		{
			answer.push_back(ans);
		}
	}

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