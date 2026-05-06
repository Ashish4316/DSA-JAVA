class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        for(int i = 0;i < n;i++){
            for(int j = m-2;j >= 0;j--){
                if(boxGrid[i][j] == '#'){
                    boxGrid[i][j] = '.';
                    int k = j;
                    while(k < m && boxGrid[i][k] == '.'){
                        k++;
                    }
                    boxGrid[i][k-1] = '#';
                }
            }
        }
        char [][] answer = new char[m][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                answer[j][n-1-i] = boxGrid[i][j];
            }
        }
        return answer;
    }
}