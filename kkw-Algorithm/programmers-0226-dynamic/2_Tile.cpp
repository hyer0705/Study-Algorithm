#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>
#include <functional>

using namespace std;

long long solution(int N) {
	
	long long answer = 4;

	// 정사각형 한 변의 길이
	long long before = 0; 
	long long now = 1;
	long long next = 0;

	for (int i = 1; i < N; i++) {
		next = before + now;
		answer = answer + (next * 3) - next;
		before = now;
		now = next;
	}

	return answer;
}

int main()
{
	int N = 5;

	cout << "answer = " << solution(6);
}