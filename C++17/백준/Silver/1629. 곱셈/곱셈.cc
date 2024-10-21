#include <iostream>

long long num = 1;

long long pow(long long a, long long b, long long c) {
	if (b == 1) {
		return a % c;
	}
	long long val = pow(a, b / 2, c);
	val = val * val % c;
	if (b % 2 == 0) {
		return val % c;
	}
	return val * a % c;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(NULL);

	long long a, b, c;
	std::cin >> a >> b >> c;
	
	std::cout << pow(a, b, c);
}