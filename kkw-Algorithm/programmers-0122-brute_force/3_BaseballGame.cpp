#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> baseball) {
	
	// 세 자리로 만들 수 있는 모든 조합 뽑아내기
	
	int answer = 0;

	int n = 9;
	int r = 3;

	vector<int> idx;
	vector<int> list;

	vector<string > results;

	for (int i = 1; i <= n; i++) {
		list.push_back(i);
	}

	for (int i = 0; i < r; i++)
		idx.push_back(1);
	for (int i = 0; i < n - r; i++)
		idx.push_back(0);

	sort(idx.begin(), idx.end(), greater<int>());

	do {
		string s;

		for (int i = 0; i < n; i++) {

			if (idx[i] == 1)
				s += to_string(list[i]);
		}

		do {
			string p;

			for (int j = 0; j < s.size(); j++) {

				p += s[j];
			}

			results.push_back(p);

		} while (next_permutation(s.begin(), s.end()));

	} while (next_permutation(idx.begin(), idx.end(), greater<int>()));


	// 주어진 문제마다 만든 조합들을 모두 돌려 해당 안될경우 삭제, 남은 조합들로 다음 문제 진행

	for (auto j : baseball) {

		string q = to_string(j[0]);

		vector<string> temp;

		for (int i = results.size() - 1; i >= 0; i--) {

			int s = 0;
			int b = 0;

			for (int k = 0; k < 3; k++)
			{
				int index = q.find(results[i][k]);

				if (index == k) s++;
				else if (index != string::npos) b++;
			}

			if ((s == j[1] && b == j[2])) {

				temp.push_back(results[i]);
			}
			results.pop_back();

		}

		for (auto i : temp) {
			results.push_back(i);
		}
	}

	answer = results.size();
	return answer;
}

int main() {

	vector<vector<int>> baseball = { {123, 1, 1},{356, 1, 0},{327, 2, 0},{489, 0, 1} };
	
	cout << solution(baseball);
}