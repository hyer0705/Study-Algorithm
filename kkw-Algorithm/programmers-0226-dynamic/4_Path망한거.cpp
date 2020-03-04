#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool IsPuddle(int i, int j, vector<vector<int>> puddles)
{
	vector<int> point = { i + 1,j + 1 };

	if (find(puddles.begin(), puddles.end(), point) != puddles.end())
	{
		return true;
	}
	else
	{
		return false;
	}
}

int FindPath(int m, int n, int i, int j, vector<vector<int>> puddles, int answer)
{
	cout << endl;

	while (i < m && j < n)
	{
		cout << i << ", " << j << endl;

		if (i + 1 < m && !IsPuddle(i + 1, j, puddles))
		{
			if (j + 1 < n && !IsPuddle(i, j + 1, puddles))
			{
				answer = FindPath(m, n, i, j + 1, puddles, answer);
			}

			++i;
		}
		else if (j < n - 1 && !IsPuddle(i, j, puddles))
		{
			++j;
		}
		else if (i == m - 1 && j == n - 1)
		{
			return answer + 1;
		}
		else
		{
			return answer;
		}
	}

}

int solution(int m, int n, vector<vector<int>> puddles) {

	int answer = 0;

	int i = 0;
	int j = 0;

	answer = FindPath(m, n, i, j, puddles, answer);

	return answer;
}

int main() {

	int m = 4;
	int n = 3;

	vector<vector<int>> puddles = { {2,2} };

	cout << solution(m, n, puddles);
}