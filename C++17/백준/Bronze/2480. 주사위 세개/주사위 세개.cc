#include <iostream>

int main()
{
    int dice1 = 0;
    int dice2 = 0;
    int dice3 = 0;
    int result = 0;

    std::cin >> dice1 >> dice2 >> dice3;

    if (dice1 == dice2 && dice2 == dice3) {
        result = 10000 + dice1 * 1000;
    }
    else if (dice1 != dice2 && dice2 != dice3 && dice1 != dice3) {
        if (dice1 > dice2 && dice1 > dice3) {
            result = dice1 * 100;
        }
        else if (dice2 > dice1 && dice2 > dice3) {
            result = dice2 * 100;
        }
        else {
            result = dice3 * 100;
        }
    }
    else {
        if (dice1 == dice2 && dice1 != dice3) {
            result = 1000 + dice1 * 100;
        }
        else if (dice1 == dice3 && dice2 != dice3) {
            result = 1000 + dice1 * 100;
        }
        else {
            result = 1000 + dice2 * 100;
        }
    }

    std::cout << result;

    return 0;
}