// 오류 수정 중

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>


using namespace std;

int solution(vector<int> people, int limit) {
	int answer = 0;

	vector<int> saved;

	while (saved.size() < people.size())
	{
		vector<int> left;

		for (int i : people) 
		{
			if (find(saved.begin(), saved.end(), i) != saved.end())
			{
				left.push_back(i);
			}
		}

		int person1 = -1;
		int person2 = -1;

		int turn = 0;

		/*for (int i = 0; i < people.size(); i++) 
		{
			if (find(saved.begin(), saved.end(), i) != saved.end()) continue;

			person1 = i;

			for (int j = 0; j < people.size(); j++) 
			{
				if (i == j || find(saved.begin(), saved.end(), j) != saved.end()) continue;

				int total = people[i] + people[j];

				if (total > turn && total <= limit) 
				{
					person2 = j;
					turn = total;
				}
			}
		}
*/

		for (int i = 0; i < left.size() - 1; i++)
		{
			person1 = i;
			person2 = i + 1;
		
			int total = left[i] + left[i+1];

			if (total > turn && total <= limit)
			{
				turn = total;
				person1 = i;
				person2 = i + 1;
			}

		}

		left.clear();

		saved.push_back(person1);

		if (person2 >= 0) 
		{
			saved.push_back(person2);
		}

		cout << "1= " << person1 << "  2= " << person2 << endl;

		++answer;

	}

	return answer;
}

int main() {

	vector<int> people = { 70, 80, 50 };
	cout << solution(people, 100);
}