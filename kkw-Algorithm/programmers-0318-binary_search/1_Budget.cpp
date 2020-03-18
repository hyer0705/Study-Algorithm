#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <numeric>

using namespace std;

int check_sum(vector<int>::iterator begin, vector<int>::iterator end, vector<int>::iterator mid)
{
	int sum = accumulate(begin, mid, 0);
	sum += (*mid * (end - mid));

	return sum;
}

int solution(vector<int> budgets, int M) {
	
	int answer = 0;

	sort(budgets.begin(), budgets.end());

	vector<int>::iterator start = budgets.begin();
	vector<int>::iterator end = budgets.end();

	vector<int>::iterator mid = budgets.begin() + (budgets.size() / 2);
	int sum = 0;

	while (end - start > 1)
	{
		sum = check_sum(budgets.begin(), budgets.end(), mid);

		if (sum > M)
		{
			end = mid;
		}
		else
		{
			start = mid;
		}

		cout << *start << endl;
		cout << *mid << endl;
		cout << *end << endl;
		cout << endl;

		mid = start + ((end - start)/2);
	}

	cout << *mid << endl;
	answer = (M - accumulate(budgets.begin(), mid+1, 0)) / ((budgets.end() - 1) - mid);

	return answer;
}

int main()
{
	vector<int> budgets = { 120, 110, 140, 150 };
	int M = 485;

	cout << solution(budgets, M);
}