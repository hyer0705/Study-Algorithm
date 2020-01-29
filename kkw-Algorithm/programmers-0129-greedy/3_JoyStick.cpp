// 실행 성공
// 제출 성공

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <cstdlib>

using namespace std;

int solution(string name) {

	vector<int> indexes;

	int answer = 0;
	int cursor = 0;

	for (int i = 0; i < name.size(); i++)
	{
		cout << "--- " << i << " ---" << endl;

		int min = name.size();
		int index = 0;
		int moves = 0;

		for (int j = 0; j < name.size(); j++) 
		{
			int change =
				(name[j] - 'A' < 14 ? name[j] - 'A' : abs(name[j] - 'A' - 26));
			
			int move = (abs(cursor - j) > (name.size() / 2) ? (j - name.size()) * -1 + cursor : abs(cursor - j));

			if (i == 0) 
			{
				moves = change;
				index = cursor;
				break;
			}
			else 
			{
				if (cursor != j && 
					move < min && 
					find(indexes.begin(), indexes.end(), j) == indexes.end() && 
					name[j] != 'A') 
				{
					min = move;
					index = j;
					moves = move + change;
				}

			}

			cout << name[j] << " = " << "move = " << move << "\t change = " << change << "\t moves = " << moves << endl;
		}

		answer += moves;
		cout << "cur answer = " << answer << endl << endl;
		indexes.push_back(index);
		
		cursor = index;
	}

	return answer;
}

int main() {

	cout << solution("JAZ");
}