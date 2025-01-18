#include <iostream>
#include <cmath>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int A, B, V;
	cin >> A >> B >> V;

	int result = ceil(static_cast<double>((V - A)) / (A - B));

	cout << result + 1;
}