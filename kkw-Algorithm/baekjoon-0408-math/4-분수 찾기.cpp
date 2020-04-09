#include <iostream>

using namespace std;

int main() 
{
	int N, a, b, start = 1, cnt = 2;
	cin >> N;

	while (N > start)
	{
		start += cnt;
		++cnt;
	}

	if (cnt % 2 == 0)
	{
		a = start - N + 1;
		b = cnt - a;
	}
	else 
	{
		b = start - N + 1;
		a = cnt - b;
	}

	cout << a << "/" << b;

	return 0;
}