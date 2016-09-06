process.stdin.resume();
process.stdin.setEncoding('ascii');
//https://www.hackerrank.com/challenges/angry-professor
var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
    input_stdin += data;
});

process.stdin.on('end', function () {
    input_stdin_array = input_stdin.split("\n");
    main();    
});

function readLine() {
    return input_stdin_array[input_currentline++];
}

/////////////// ignore above this line ////////////////////

function main() {
    var t = parseInt(readLine());
    for(var a0 = 0; a0 < t; a0++){
        var n_temp = readLine().split(' ');
        var n = parseInt(n_temp[0]);
        var k = parseInt(n_temp[1]);
        a = readLine().split(' ');
        a = a.map(Number);
        var count = 0;
        for(var a2 = 0; a2 < n; a2++){
            count += (a[a2]<=0)?1:0;
        }
        if(count >= k){
            console.log("NO");
        }
        else{
            console.log("YES");
        }
    }

}
