#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

int N, M;
int first[9];
int arr[9];
bool visited[9];
set<vector<int>> s;

void dfs(int start, int cnt) {
    if (cnt == M) {
        vector<int> v;
        for (int i = 0; i < M; i++)
            v.push_back(arr[i]);
        s.insert(v);
        v.clear();
    }
    else {
        for (int i = start; i < N; i++) {
            arr[cnt] = first[i];
            dfs(i, cnt + 1);
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M;

    for (int i = 0; i < N; i++)
        cin >> first[i];

    sort(first, first + N);

    dfs(0, 0);

    for (auto vector : s) {
        for (auto temp : vector) {
            cout << temp << " ";
        }
        cout << '\n';
    }
}