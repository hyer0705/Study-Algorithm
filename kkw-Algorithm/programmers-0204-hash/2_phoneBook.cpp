#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool solution(vector<string> phone_book) {

	bool answer = true;

	sort(phone_book.begin(), phone_book.end());

	for (int i = 0; i < phone_book.size() - 1; i++)
	{
		for (int j = i + 1; j < phone_book.size(); j++) 
		{
			if (phone_book[j].find(phone_book[i]) != string::npos)
			{
				return false;
			}
		}
	}

	return true;
}

int main()
{
	vector<string> phone_book = { "119", "97674223", "1195524421" };

	cout << solution(phone_book);
}