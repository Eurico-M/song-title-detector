#include <bits/stdc++.h>

using namespace std;

int main(int argc, char *argv[]) {

    string raw_name;

    if (argc > 0) {
        raw_name = argv[1];
    }

    if (raw_name != "") {
        cout << "Window Name is: " << argv[1] << "\n";
    }

    return 0;
}
