#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> triangle) {
	int answer = 0;

	vector<vector<int>> bpath;
	vector<vector<int>> cpath;

	cpath.push_back(triangle[0]);

	for (int i = 0; i < triangle.size(); ++i) {

		for (int j = 0; j < triangle[i].size(); ++j) 
		{

			for (int n = j - 1; n <= j; ++n) 
			{
				if (n < bpath.size()) 
				{
					vector<int> temp;

					for (int m = 0; m < bpath[n].size(); ++m)
					{
						temp.push_back(bpath[n][m] + triangle[i][j]);
					}

					cpath.push_back(temp);
				} 
			}
		}

		bpath.clear();

		for (int n = 0; n < cpath.size(); n++) 
		{
			bpath.push_back(cpath[n]);
		}

		cpath.clear();
	}

	vector<int> answers;

	for (int i = 0; i < bpath.size(); i++) 
	{
		answers.push_back(*max_element(bpath[i].begin(), bpath[i].end()));
	}

	answer = *max_element(answers.begin(), answers.end());
	return answer;
}

int main() {

	/*vector<int> scoville = { 1, 2, 3, 9, 10, 12 };
	int K = 7;
*/

	vector<vector<int>> triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
	
	cout << solution(triangle);
}