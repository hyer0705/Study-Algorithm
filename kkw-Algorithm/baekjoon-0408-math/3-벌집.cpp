#include <iostream>

using namespace std;

int main() 
{
	int N, start = 1, ans = 1;
	cin >> N;

	// 육각형의 변에 위치하는 수 중 가장 큰 숫자는 1, 7, 19, 37 순으로 늘어나는데
	// 6의 배수만큼 늘어나고 있으므로 해당 숫자로 도달할때까지 1에서부터 6의 배수를 계속 더해줌
	while (start < N)
	{
		start += (ans * 6);
		++ans;
	}

	cout << ans;

	return 0;
}