#include <iostream>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    string a, b, c;
    int num = 0;
    cin >> a >> b >> c;

    if (a != "Fizz" && a != "Buzz" && a != "FizzBuzz") {
        num = stoi(a) + 3;
    }
    else if (b != "Fizz" && b != "Buzz" && b != "FizzBuzz") {
        num = stoi(b) + 2;
    }
    else if (c != "Fizz" && c != "Buzz" && c != "FizzBuzz") {
        num = stoi(c) + 1;
    }

    if (num % 3 == 0 && num % 5 == 0) {
        cout << "FizzBuzz";
    }
    else if (num % 3 == 0) {
        cout << "Fizz";
    }
    else if (num % 5 == 0) {
        cout << "Buzz";
    }
    else {
        cout << num;
    }
}