#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
	int answer = 0;

	queue<int> bridge;

	int truck = -1;
	int current_weight = 0;
	
	while (true)
	{
		if (bridge.size() >= bridge_length)
		{
			current_weight -= bridge.front();
			bridge.pop();
		}

		++truck;

		if (truck >= truck_weights.size())
		{
			break;
		}

		if (current_weight + truck_weights[truck] <= weight)
		{
			bridge.push(truck_weights[truck]);
			current_weight += truck_weights[truck];
		}

		else
		{
			--truck;
			bridge.push(0);
		}

		answer++;

		cout << answer << " :   " ;

		for (int i = 0; i < bridge.size(); i++)
		{
			int n = bridge.front();
			cout << n << " ";
			bridge.pop();
			bridge.push(n);
		}

		cout << endl;

	}
	
	return answer + bridge_length;
}

int main()
{
	vector<int> truck_weights = { 7,4,5,6 };
	
	cout << solution(2, 10, truck_weights);
}