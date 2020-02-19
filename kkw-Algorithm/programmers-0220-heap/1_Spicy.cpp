// 정확성테스트 1,3,8,14번 통과 안됨

#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {

	int answer = 0;

	priority_queue<int, vector<int>, greater<int>> less;

	for (int i : scoville) {
		if (i < K) { less.push(i); }
	}

	if (less.empty()) { return answer; }

	while (less.top() < K) 
	{
		int n = less.top();
		less.pop();
		n += less.top() * 2;
		less.pop();

		less.push(n);
		++answer;
	}

	return answer;
}

int main()
{
	vector<int> scoville = { 1, 2, 3, 9, 10, 12 };
	
	cout << "answer = " << solution(scoville, 7);
}