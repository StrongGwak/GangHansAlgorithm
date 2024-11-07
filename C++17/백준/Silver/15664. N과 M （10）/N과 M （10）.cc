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

void dfs(int cnt, int start) {
    if (cnt == M) {
        vector<int> v;
        for (int i = 0; i < M; i++)
            v.push_back(arr[i]);
        s.insert(v);
        v.clear();
    }
    else {
        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = first[i];
                dfs(cnt + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}

int main() {
    cin >> N >> M;

    for (int i = 0; i < N; i++)
        cin >> first[i];

    sort(first, first + N);

    dfs(0, 0);

    for (auto vector : s) {
        for (auto temp : vector)
            cout << temp << " ";
        cout << "\n";
    }
}