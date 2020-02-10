#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <stack>

using namespace std;

vector<int> solution(vector<int> heights) {
	
	vector<int> answer;

	// 인덱스 값을 저장해나갈 스택
	stack<int> sent;

	for (int i = 0; i < heights.size(); i++) 
	{
		// 비어있지 않거나 top에 저장된 인덱스 위치+1에 있는 값이 현재 값보다 크지 않을 경우 pop
		while (!sent.empty() && heights[sent.top()-1] <= heights[i])
		{
			sent.pop();
		}

		// 다 지워져버렸거나 원래 비어있었을 경우(맨처음) answer에 0 넣기
		if (sent.empty())
		{
			answer.push_back(0);
		}

		// 아닐 경우 현재 top 인덱스 answer에 넣기
		else 
		{
			answer.push_back(sent.top());
		}

		// answer는 첫번째가 1이여야하므로 i+1 넣어주기
		sent.push(i+1);
	}

	return answer;
}

int main()
{
	vector<int> heights = { 6,9,5,7,4 };
	
	for (int i : solution(heights)) 
	{
		cout << i << " ";
	}
}