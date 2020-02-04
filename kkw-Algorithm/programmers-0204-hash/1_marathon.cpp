#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {

	string answer = "";

	sort(completion.begin(), completion.end());
	sort(participant.begin(), participant.end());
	
	for (int i = 0; i <= completion.size(); i++) 
	{
		if (completion[i] != participant[i])
		{
			return participant[i];
		}
	}

	return *(participant.end() - 1);
}

int main() 
{
	vector<string> participant = { "mislav", "stanko", "mislav", "ana" };
	vector<string> completion = { "stanko", "ana", "mislav"};

	cout << solution(participant, completion);

}