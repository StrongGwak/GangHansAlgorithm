#include <iostream>

int main() {
    int nums[201] = { 0 };
    int n = 0;
    int v = 0;
    std::cin >> n;
    for (int i = 0; i < n; i++) {
        int a = 0;
        std::cin >> a;
        a += 100;
        nums[a]++;
    }
    std::cin >> v;
    v += 100;
    std::cout << nums[v];
    return 0;
}