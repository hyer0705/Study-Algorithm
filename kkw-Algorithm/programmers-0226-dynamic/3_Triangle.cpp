#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> triangle) {
	int answer = 0;

	for (int i = 1; i < triangle.size(); ++i) 
	{
		for (int j = 0; j < triangle[i].size(); ++j)
		{
			int l = 0, r = 0;

			if (j > 0) { l = triangle[i - 1][j - 1]; }
			if (j < i) { r = triangle[i - 1][j]; }

			triangle[i][j] += l >= r ? l : r;
		}
	}

	answer = *max_element(triangle[triangle.size() - 1].begin(), triangle[triangle.size() - 1].end());

	return answer;
}

int main() {

	vector<vector<int>> triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
	
	cout << solution(triangle);
}