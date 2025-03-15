#include <iostream>

using namespace std;

char l[26], r[26];

void preorder(int p) {
	char letter = 'A' + p;
	cout << letter;
	if (l[p] != '.') {
		preorder(l[p] - 'A');
	}
	if (r[p] != '.') {
		preorder(r[p] - 'A');
	}
}

void inorder(int p) {
	if (l[p] != '.') {
		inorder(l[p] - 'A');
	}
	char letter = 'A' + p;
	cout << letter;
	if (r[p] != '.') {
		inorder(r[p] - 'A');
	}
}

void postorder(int p) {
	if (l[p] != '.') {
		postorder(l[p] - 'A');
	}
	if (r[p] != '.') {
		postorder(r[p] - 'A');
	}
	char letter = 'A' + p;
	cout << letter;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		char p;
		cin >> p;
		cin >> l[p - 'A'] >> r[p - 'A'];
	}

	preorder(0);
	cout << '\n';
	inorder(0);
	cout << '\n';
	postorder(0);
}