#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <stack>

using namespace std;

vector<int> solution(vector<int> heights) {
	
	vector<int> answer;

	// �ε��� ���� �����س��� ����
	stack<int> sent;

	for (int i = 0; i < heights.size(); i++) 
	{
		// ������� �ʰų� top�� ����� �ε��� ��ġ+1�� �ִ� ���� ���� ������ ũ�� ���� ��� pop
		while (!sent.empty() && heights[sent.top()-1] <= heights[i])
		{
			sent.pop();
		}

		// �� ���������Ȱų� ���� ����־��� ���(��ó��) answer�� 0 �ֱ�
		if (sent.empty())
		{
			answer.push_back(0);
		}

		// �ƴ� ��� ���� top �ε��� answer�� �ֱ�
		else 
		{
			answer.push_back(sent.top());
		}

		// answer�� ù��°�� 1�̿����ϹǷ� i+1 �־��ֱ�
		sent.push(i+1);
	}

	return answer;
}

int main()
{
	vector<int> heights = { 6,9,5,7,4 };
	
	for (int i : solution(heights)) 
	{
		cout << i << " ";
	}
}