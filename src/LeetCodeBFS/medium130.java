package LeetCodeBFS;

import java.util.LinkedList;

/**
 * Created by luoshalin on 12/21/15.
 */

// Method1:
// DFS w/ recursion
// stackoverflow problem
//public class medium130 {
//    public static void main(String[] args){
//        // test goes here
//    }
//
//    public void solve(char[][] board) {
//        if(board==null || board.length<=2 || board[0].length<=2)
//            return;
//
//        // row>=3 && col>=3
//        int row = board.length;
//        int col = board[0].length;
//
//        // mask first row & last row - [0][i] & [row-1][i]
//        for(int i=0; i<col; i++){
//            if(board[0][i]=='O')
//                mask(board, row, col, 0, i);
//            if(board[row-1][i]=='O')
//                mask(board, row, col, row-1, i);
//        }
//        // mask first col & last col - [i][0] & [i][row-1]
//        for(int i=0; i<row; i++){
//            if(board[i][0]=='O')
//                mask(board, row, col, i, 0);
//            if(board[i][row-1]=='O')
//                mask(board, row, col, i, row-1);
//        }
//
//        for(int i=0; i<col; i++){
//            for(int j=0; j<col; j++){
//                if(board[i][j] == 'O')
//                    board[i][j] = 'X';
//                else if(board[i][j] == '#')
//                    board[i][j] = 'O';
//            }
//        }
//    }
//
//    // helpers
//    public static void mask(char[][] board, int row, int col, int i, int j){
//        // process current
//        if(board[i][j]=='O')
//            board[i][j] = '#';
//        else                                // CAUTION: VERY EASY TO FORGET RETURN HERE
//            return;
//        // process up
//        if(i-1>=0 && board[i-1][j]=='O')
//            mask(board, row, col, i-1, j);
//        // process down
//        if(i+1<row && board[i+1][j]=='O')
//            mask(board, row, col, i+1, j);
//        // process left
//        if(j-1>=0 && board[i][j-1]=='O')
//            mask(board, row, col, i, j-1);
//        // process right
//        if(j+1<col && board[i][j+1]=='O')
//            mask(board, row, col, i, j+1);
//        return;
//    }
//}

public class medium130 {
    public static void main(String[] args){
        // test goes here
    }

    public void solve(char[][] board) {
        if(board==null || board.length<=2 || board[0].length<=2)
            return;

        // row>=3 && col>=3
        int row = board.length;
        int col = board[0].length;

        // mask first row & last row - [0][i] & [row-1][i]
        for(int i=0; i<col; i++){
            if(board[0][i]=='O')
                mask(board, row, col, 0, i);
            if(board[row-1][i]=='O')
                mask(board, row, col, row-1, i);
        }
        // mask first col & last col - [i][0] & [i][row-1]
        for(int i=0; i<row; i++){
            if(board[i][0]=='O')
                mask(board, row, col, i, 0);
            if(board[i][row-1]=='O')
                mask(board, row, col, i, row-1);
        }

        for(int i=0; i<col; i++){
            for(int j=0; j<col; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    // helpers
    public static void mask(char[][] board, int row, int col, int i, int j){
        // process current
        if(board[i][j]!='O')
            return;

        board[i][j] = '#';
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(i*col+j);
        while(!q.isEmpty()){
            int cur = q.poll();
            int curI = cur/col;
            int curJ = cur%col;
            // cur node: board[curRow][curCol]
            // examine up/down/left/right nodes of curNode, if is'O', added to this level
            // process up
            if(curI-1>=0 && board[curI-1][curJ]=='O'){
                board[curI-1][curJ] = '#';
                q.add((curI-1)*col + curJ);
            }
            // process down
            if(curI+1<row && board[curI+1][curJ]=='O'){
                board[curI+1][curJ] = '#';
                q.add((curI+1)*col + curJ);
            }
            // process left
            if(curJ-1>=0 && board[curI][curJ-1]=='O'){
                board[curI][curJ-1] = '#';
                q.add(curI*col + curJ-1);
            }
            // process right
            if(curJ+1<col && board[curI][curJ+1]=='O'){
                board[curI][curJ+1] = '#';
                q.add(curI*col + curJ+1);
            }
        }

    }
}
