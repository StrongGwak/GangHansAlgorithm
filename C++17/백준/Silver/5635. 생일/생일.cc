#include <iostream>
#include <string>
#include <vector>
#include <algorithm>


struct Node
{
    std::string name;
    int day;
    int month;
    int year;
};

bool cmp(Node a, Node b) {
    if (a.year == b.year) {
        if (a.month == b.month) {
            return a.day > b.day;
        }
        else {
            return a.month > b.month;
        }
    }
    else {
        return a.year > b.year;
    }
}

int main() {
    int n = 0;
    std::vector<Node> persons;
    std::cin >> n;
    for (int i = 0; i < n; i++) 
    {
        Node node;
        std::cin >> node.name >> node.day >> node.month >> node.year;
        persons.emplace_back(node);
    }
    sort(persons.begin(), persons.end(), cmp);

    std::cout << persons[0].name << '\n' << persons[n - 1].name;
}