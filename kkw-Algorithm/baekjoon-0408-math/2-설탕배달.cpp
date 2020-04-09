// 실패실패 대실패
#include <iostream>

using namespace std;

int main() 
{
	int N, ans = 0;
	cin >> N;

	if (N % 5 == 0)
	{
		ans = N / 5;
	}
	else if ((N % 5) % 3 == 0) 
	{
		ans = N / 5;
		ans += (N - (5 * ans)) / 3;
	}
	else if ((((N - 5) % 5) + 5) % 3 == 0)
	{
		ans = (N - 5) / 5;
		ans += (N - (5 * ans)) / 3;
	}
	else if (N % 3 == 0)
	{
		ans = N / 3;
	}
	else
	{
		ans = -1;
	}

	cout << ans;

	return 0;
}