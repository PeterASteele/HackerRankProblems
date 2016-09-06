#include<iostream>
#include<vector>
#include<queue>
//https://www.hackerrank.com/challenges/botcleanlarge
using namespace std;
void next_move(int posr, int posc, int dimh, int dimw, vector <string> board) {
    //let's greedily move towards the nearest dirt.
    queue <int> bfs;
    bfs.push(posr*100+posc);
    bool visited[dimh][dimw];
    for(int i = 0; i < dimh; i++){
        for(int j = 0; j < dimw; j++){
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
        if(tempX < dimh-1){
            if(!visited[tempX+1][tempY]){
                cerr << tempX << " " << dimw << "\n";
                bfs.push((tempX+1)*100 + tempY);
            }
        }
        if(tempY > 0){
            if(!visited[tempX][tempY-1]){
                bfs.push((tempX)*100 + tempY-1);
            }
        }
        if(tempY < dimw-1){
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
    int dim[2];
    vector <string> board;
    cin>>pos[0]>>pos[1];
    cin>>dim[0]>>dim[1];
    for(int i=0;i<dim[0];i++) {
        string s;cin >> s;
        board.push_back(s);
    }
    next_move(pos[0], pos[1], dim[0], dim[1], board);
    return 0;
}