#include <iostream>

using namespace std;

int main() 
{
	int N, start = 1, ans = 1;
	cin >> N;

	// �������� ���� ��ġ�ϴ� �� �� ���� ū ���ڴ� 1, 7, 19, 37 ������ �þ�µ�
	// 6�� �����ŭ �þ�� �����Ƿ� �ش� ���ڷ� �����Ҷ����� 1�������� 6�� ����� ��� ������
	while (start < N)
	{
		start += (ans * 6);
		++ans;
	}

	cout << ans;

	return 0;
}