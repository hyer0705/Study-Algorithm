#include <iostream>

using namespace std;

int main() 
{
	int a, b, v;
	cin >> a >> b >> v;

	cout << (v - a) / (a - b) + 1;

	return 0;
}