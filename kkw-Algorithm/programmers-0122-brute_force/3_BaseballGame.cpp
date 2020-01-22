#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

// 아직 미완!!!

int solution(vector<vector<int>> baseball) {
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


	for (auto j : baseball) {

		for (int i = results.size() - 1; i >= 0; i--) {

			int s = 0;
			int b = 0;

			string q = to_string(j[0]);

			for (int k = 0; k < 3; k++)
			{
				int index = q.find(results[i][k]);

				if (index == k) s++;
				else if (index != string::npos) b++;
			}



			if (!(s == j[1] && b == j[2])) {
				cout << i << " " << results[i]<< " pop" << endl;
				results.pop_back();
				i--;
			}
		}

		cout << "next" << endl << endl;
				
	}

	answer = results.size();
	return answer;
}

int main() {

	vector<vector<int>> baseball = { {123, 1, 1},{356, 1, 0},{327, 2, 0},{489, 0, 1} };
	
	cout << solution(baseball);
}