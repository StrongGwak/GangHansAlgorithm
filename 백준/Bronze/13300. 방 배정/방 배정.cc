#include <iostream>

int main()
{
    int n = 0;
    int k = 0;
    int room[7][2] = { 0 };
    int rooms = 0;

    std::cin >> n >> k;
    for (int i = 0; i < n; i++) {
        int sex = 0;
        int grade = 0;
        std::cin >> sex >> grade;
        room[grade][sex]++;
    }

    for (int i = 1; i <= 6; i++) {
        for (int j = 0; j < 2; j++) {
            if (room[i][j] == 0) {
                continue;
            }
            else if (room[i][j] > k) {
                rooms += room[i][j] / k + 1;
            }
            else {
                rooms++;
            }
        }
    }

    std::cout << rooms;
}