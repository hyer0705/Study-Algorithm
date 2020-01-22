#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string numbers) {
	
	int answer = 0;

	vector<int> powerset;

	for (int i = 0; i < (1 << (numbers.size())); ++i) {

		string s;

		for (int j = 0; j < numbers.size(); ++j) {

			if (i & (1 << j))
			{
				s += numbers[j];
			}
		}

		if (s.size() > 1) 
		{
			do {

				string p;

				for (int j = 0; j < s.size(); j++) {
					p += s[j];
				}

				powerset.push_back(atoi(p.c_str()));

			} while (next_permutation(s.begin(), s.end()));
		}
		else 
		{
			powerset.push_back(atoi(s.c_str()));
		}
	}

	sort(powerset.begin(), powerset.end());

	int prev = 0;

	for (int i : powerset) 
	{
		if (prev == i || i <= 1) continue;

		bool isPrime = false;

		for (int j = 2; j < i; j++) 
		{
			if (i % j == 0) {
				isPrime = true;
				break;
			}
		}

		if (!isPrime) {
			++answer;
		}

		prev = i;
	}

	return answer;
}

void main()
{
	cout<< solution("011");
	
}