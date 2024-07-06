#include <iostream>
#include <string>

const int mx = 1000005;
int data[mx];
int head, tail;

void push(int value) {
	data[tail++] = value;
}
void pop() {
	head++;
}

int main() {
	int n;
	std::cin >> n;
	for (int i = 0; i < n; i++) {
		std::string order;
		std::cin >> order;
		if (order == "push") {
			int num;
			std::cin >> num;
			push(num);
		}
		else if (order == "pop") {
			if (head == tail) {
				std::cout << -1 << '\n';
			}
			else {
				std::cout << data[head] << '\n';
				pop();
			}
		}
		else if (order == "size") {
			std::cout << tail - head << '\n';
		}
		else if (order == "empty") {
			if (head == tail) {
				std::cout << 1 << '\n';
			}
			else {
				std::cout << 0 << '\n';
			}
		}
		else if (order == "front") {
			if (head == tail) {
				std::cout << -1 << '\n';
			}
			else {
				std::cout << data[head] << '\n';
			}
		}
		else if (order == "back") {
			if (head == tail) {
				std::cout << -1 << '\n';
			}
			else {
				std::cout << data[tail - 1] << '\n';
			}
		}
	}
}