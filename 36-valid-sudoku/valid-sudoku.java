class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> set = new HashSet<>();
            int count = 0;
            for(int j = 0; j<9; j++){
                char ch = board[i][j];
                if(ch != '.'){
                    set.add(ch);
                    count++;
                }
            }
            if(set.size() < count){
                return false;
            }
            set.clear();
            count = 0;
            for(int j = 0; j<9; j++){
                char ch = board[j][i];
                if(ch != '.'){
                    set.add(ch);
                    count++;
                }
            }
            if(set.size()<count){
                return false;
            }
            set.clear();
            count = 0;
            for(int j = 0; j<9; j++){
                int row = 3*(i/3) +j/3;
                int col = 3*(i%3) + j%3;
                char ch = board[row][col];
                if(ch != '.'){
                    set.add(ch);
                    count++;
                }
            }
            if(set.size()<count){
                return false;
            }
        }
        return true;
    }
}