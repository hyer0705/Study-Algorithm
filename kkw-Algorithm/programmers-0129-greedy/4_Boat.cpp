#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
	
	int answer = 0; 

	sort(people.begin(), people.end()); // 몸무게를 오름차순으로 정렬

	int saved = 0; // 구조된 사람 수

	vector<int>::iterator person1 = people.begin(); // 가장 가벼운 사람부터 시작
	vector<int>::iterator person2 = people.end();	// 가장 무거운 사람부터 시작

	while (saved < people.size()) // people의 수 만큼 모두 구조되면 종료
	{
		// 무거운 사람은 턴마다 무조건 구조
		//(people.end()는 끝+1의 위치를 가리키는 포인터이므로 처음 시작할때 한번 빼주는 것도 있음)
		person2--;
		++saved;

		// 가벼운 사람의 몸무게와 무거운 사람의 몸무게 합이 limit보다 작으면 가벼운 사람도 구조
		if (*person1 + *person2 <= limit) 
		{
			++saved;
			++person1;
		}

		++answer; // 턴 더해주기
	}

	return answer;
}

int main() {

	vector<int> people = { 70, 80, 50 };
	cout << solution(people, 100);
}