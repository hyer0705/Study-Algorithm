#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {

	vector<int> answer;

	int score[] = { 0, 0, 0 };

	for (int i = 0; i < answers.size(); ++i) 
	{
		if (answers[i] == (i % 5 + 1))
		{
			++score[0];
		}

		if (i % 2 == 0) {
			if(answers[i] == 2)
				++score[1];
		}

		else{

			if (answers[i] == ((i / 2) % 4 + 2 == 2 ? (i / 2) % 4 + 1 : (i / 2) % 4 + 2)) 
			{
				++score[1];
			}
		}

		int n = i < 10 ? i / 2 + 1 : (i % ((i / 10) * 10) / 2) + 1;

		if (n == 2 || n == 3) n--;
		else if (n == 1) n = 3;

		if (n == answers[i]) 
		{
			++score[2];
		}
	}

	int max = -1;

	for (int i : score)
	{
		
		if (max < i) 
		{
			max = i;
		}
	}

	for (int i = 0; i < 3; i++) 
	{
		if (score[i] == max) 
		{
			answer.push_back(i+1);
		}
	}
	
	return answer;
}

void main()
{
	vector<int> numbers = { 1,3,2,4,2 };
	vector<int> answer = solution(numbers);

	for (int i : solution(numbers)) {
		cout << i << " ";
	}
}