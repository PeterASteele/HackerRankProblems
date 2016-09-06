#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

//https://www.hackerrank.com/challenges/arrays-introduction
int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int n;
    cin >> n;
    int arr[n];
    for(int a = 0; a < n; a++){
        cin >> arr[a];
    }
    for(int a = n-1; a >= 0; a--){
        cout << arr[a] << " ";
    }
    return 0;
}