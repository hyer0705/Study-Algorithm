#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>
#include <functional>

using namespace std;

int solution(int stock, vector<int> dates, vector<int> supplies, int k) {
	
	int answer = 0;

	dates.push_back(k);

	for (int i = 0; i < dates.size(); i++) 
	{
		if (stock < dates[i]) 
		{
			answer++;
			stock += supplies[i - 1];
		}
	}

	return answer;
}

int main()
{
	int stock = 4;
	vector<int> dates = { 4,10,15 };
	vector<int> supplies = { 20,5,10 };
	int k = 30;

	cout << "answer = " << solution(stock, dates, supplies, k);
}