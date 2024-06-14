#include <iostream>

int main() {
    int sum = 0;
    int min = 100;
    for (int i = 0; i < 7; i++) {
        int num = 0;
        std::cin >> num;
        if (num % 2 == 1) {
            sum += num;
            if (num < min) {
                min = num;
            }
        }
    }
    if (sum == 0) {
        std::cout << -1;
    } else {
        std::cout << sum << '\n' << min;
    }
}