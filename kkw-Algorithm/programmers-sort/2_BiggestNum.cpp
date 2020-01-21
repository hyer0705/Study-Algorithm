#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

// 프로그래머스에 돌리면 오류뜨는데 왜 뜨는지 아직도 모르겠어요...ㅠㅠㅠ

bool cmp(string s1, string s2)
{
	if (s1[0] > s2[0]) 
	{
		return true;
	}

	else if (s1[0] == s2[0])
	{
		int i = 1;

		while (i < 4) 
		{
			char c1 = s1.size() > i ? s1[i] : s1[s1.size() - 1];
			char c2 = s2.size() > i ? s2[i] : s2[s2.size() - 1];

			if (c1 > c2) 
			{
				return true;
			}
			else if (c1 < c2) 
			{
				return false;
			}
			
			i++;
		}

		return true;
	}

	else
	{
		return false;
	}
	
}

string solution(vector<int> numbers) {

	string answer;

	vector<string> strings;

	for (int i = 0; i < numbers.size(); i++)
	{
		strings.push_back(to_string(numbers[i]));
	}

	sort(strings.begin(), strings.end(), cmp);

	for (int i = 0; i < strings.size(); i++) 
	{
		answer.append(strings[i]);
	}

	return answer;
}

void main()
{
	vector<int> numbers = { 3, 30, 34, 5, 9 };
	cout<< solution(numbers);
}