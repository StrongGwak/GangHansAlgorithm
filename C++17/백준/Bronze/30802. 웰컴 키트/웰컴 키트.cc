#include <iostream>

int main() {
	std::cin.tie(NULL);
	std::ios_base::sync_with_stdio(false);
	int n, t, p;
	std::cin >> n;
	int sizes[6];
	int tr = 0, pr = 0, ps = 0;
	for (int i = 0; i < 6; i++) {
		std::cin >> sizes[i];
	}
	
	std::cin >> t >> p;

	for (int i = 0; i < 6; i++) {
		if (sizes[i] % t > 0) {
			tr += (sizes[i] / t) + 1;
		}
		else {
			tr += sizes[i] / t;
		}
	}
	pr = n / p;
	ps = n % p;

	std::cout << tr << '\n' << pr << " " << ps;
}