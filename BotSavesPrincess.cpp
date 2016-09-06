#include <iostream>
#include <vector>
//https://www.hackerrank.com/challenges/saveprincess
using namespace std;
void displayPathtoPrincess(int n, vector <string> grid){
    int startX;
    int startY;
    int endX;
    int endY;
    for(int a = 0; a < n; a++){
        for(int b = 0; b < n; b++){
            if(grid[a][b] == 'm'){
                startX = a;
                startY = b;
            }
            if(grid[a][b] == 'p'){
                endX = a;
                endY = b;
            }
        }
    }
    while(startX < endX){
        cout << "DOWN\n";
        startX++;
    }    
    while(startX > endX){
        cout << "UP\n";
        startX--;
    }
    while(startY < endY){
        cout << "RIGHT\n";
        startY++;
    }    
    while(startY > endY){
        cout << "LEFT\n";
        startY--;
    }
}
int main(void) {

    int m;
    vector <string> grid;

    cin >> m;

    for(int i=0; i<m; i++) {
        string s; cin >> s;
        grid.push_back(s);
    }

    displayPathtoPrincess(m,grid);

    return 0;
}