#include <iostream>

using namespace std;

int nums[250000] = { 0 };

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for (int i = 2; i <= 250000; i++) {
        int num = i * 2;
        while (num <= 250000) {
            if (nums[num] != 1) {
                nums[num] = 1;
            }
            num += i;
        }
    }

    while (true) 
    {
        int n;
        cin >> n;
        if (n == 0) {
            break;
        }
        int result = 0;
        for (int i = n + 1; i <= n * 2; i++) {
            if (nums[i] != 1) {
                result++;
            }
        }
        cout << result << '\n';
    }

}