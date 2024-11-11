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

void dfs(int cnt) {
    if (cnt == M) {
        vector<int> v;
        for (int i = 0; i < M; i++)
            v.push_back(arr[i]);
        s.insert(v);
        v.clear();
    }
    else {
        for (int i = 0; i < N; i++) {
            arr[cnt] = first[i];
            dfs(cnt + 1);
        }
    }
}

int main() {
    cin >> N >> M;

    for (int i = 0; i < N; i++)
        cin >> first[i];

    sort(first, first + N);

    dfs(0);

    for (auto vector : s) {
        for (auto temp : vector)
            cout << temp << " ";
        cout << "\n";
    }
}