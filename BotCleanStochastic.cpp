#include<iostream>
#include<vector>
#include<queue>
//https://www.hackerrank.com/challenges/botcleanr
using namespace std;
void nextMove(int posr, int posc, vector <string> board) {
    //let's greedily move towards the nearest dirt.
    
    queue <int> bfs;
    bfs.push(posr*100+posc);
    bool visited[5][5];
    for(int i = 0; i < 5; i++){
        for(int j = 0; j < 5; j++){
            visited[i][j] = false;
        }
    }
    int ansX = -1;
    int ansY = -1;
    int count = 0;
    cerr << "START " << posr << " " << posc << "\n";
    while(!bfs.empty()){
                
        count++;
        int temp = bfs.front();
        bfs.pop();
        int tempX = temp/100;
        int tempY = temp%100;
        cerr << tempX << " " << tempY << "\n";
        if(board[tempX][tempY] == 'd'){
            ansX = tempX;
            ansY = tempY;
            break;
        }
        
        visited[tempX][tempY] = true;
        if(tempX > 0){
            if(!visited[tempX-1][tempY]){
                bfs.push((tempX-1)*100 + tempY);
            }
        }
        if(tempX < 4){
            if(!visited[tempX+1][tempY]){
                bfs.push((tempX+1)*100 + tempY);
            }
        }
        if(tempY > 0){
            if(!visited[tempX][tempY-1]){
                bfs.push((tempX)*100 + tempY-1);
            }
        }
        if(tempY < 4){
            if(!visited[tempX][tempY+1]){
                bfs.push((tempX)*100 + tempY+1);
            }
        }
        
        
        
    }
    
    //go toward dirt once we find it.
    int startX = posr;
    int startY = posc;
    int endX = ansX;
    int endY = ansY;
   
    if(startX < endX){
        cout << "DOWN";
    }    
    else if(startX > endX){
        cout << "UP";
    }
    else if(startY < endY){
        cout << "RIGHT";
    }    
    else if(startY > endY){
        cout << "LEFT";
    }    
    else{
        cout << "CLEAN";
    }
}
int main(void) {
    int pos[2];
    vector <string> board;
    cin>>pos[0]>>pos[1];
    for(int i=0;i<5;i++) {
        string s;
        cin >> s;
        board.push_back(s);
    }
    nextMove(pos[0], pos[1], board);
    return 0;
}