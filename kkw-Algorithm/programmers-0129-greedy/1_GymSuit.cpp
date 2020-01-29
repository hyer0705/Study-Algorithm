// 실행 성공
// 제출 실패

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {

	int answer = n - lost.size();

	vector<int> taken;

	for (int i : lost)
	{
		for (int j = (i - 1); j <= i + 1; j++)
		{
			vector<int>::iterator iter;

			iter = find(reserve.begin(), reserve.end(), j);
			if (iter != reserve.end() &&
				find(taken.begin(), taken.end(), *iter) == taken.end())
			{
				taken.push_back(*iter);
				answer++;
				break;
			}
		}
	}

	if (answer < 0) answer = 0;
	return answer;
}

int main() {

	vector<int> lost = { 3 };
	vector<int> reserve = { 1 };
	
	cout << solution(3, lost, reserve);
}