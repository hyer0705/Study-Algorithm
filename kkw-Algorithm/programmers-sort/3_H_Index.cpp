﻿#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
	int answer = 0;

	sort(citations.begin(), citations.end());

	for (int i = 0; i < citations.size(); i++) 
	{
		if (citations[i] <= (citations.size() - i)) {
			answer = citations[i];
		}
	}

	return answer;
}

void main()
{
	vector<int> numbers = { 3, 0, 6, 1, 5};
	cout<< solution(numbers);
}