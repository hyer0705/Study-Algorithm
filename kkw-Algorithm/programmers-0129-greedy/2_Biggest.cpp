// 실행 성공
// 제출 실패

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string number, int k) {
	
	string answer = "";

	vector<char> arr(number.begin(), number.end());

	char max = *max_element(arr.begin(), arr.end() - (arr.size() - k - 1));

	int i;

	for (i = 0; arr[i] != max; ++i) {
		if (arr[i] < max) {
			arr[i] = ' ';
			k--;
		}
	}

	int a = (i + 1);
	int b = (a + 1);

	while (k > 0) 
	{
		if (arr[a] > arr[b]) 
		{
			k--;
			arr[b] = ' ';
		}
		else if (arr[a] < arr[b]) 
		{
			k--;
			arr[a] = ' ';
			//a = b;
		}
		//b++;

		a += 2;
		b += 2;
	}


	for (char c : arr) 
	{
		if (c != ' ') {
			answer+=c;
		}
	}

	return answer;
}

int main() {

	cout << solution("4177252841", 4);
}