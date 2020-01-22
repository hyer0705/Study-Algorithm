#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(int brown, int red) {

	vector<int> answer;

	for (int i = 1; i <= red; i++) 
	{
		if (red % i == 0) 
		{
			int w = i;
			int h = red / i;

			if (w >= h && (w * 2 + h * 2 + 4) == brown) {

				answer.push_back(w+2);
				answer.push_back(h+2);

				break;
			}
		}
	}

	return answer;
}

void main()
{
	for (int i : solution(24, 24)) {
		cout << i << " ";
	}
}