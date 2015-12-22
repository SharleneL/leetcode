package LeetCodeTree_Medium;

/**
 * Created by luoshalin on 12/21/15.
 */

// Method1:
// DFS, recursive - stackoverflow
public class medium200 {
    public static void main(String[] args){
        // test goes here
        char[][] grid = {{'1', '0'}};
        System.out.print(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int res = 0;
        if(grid==null || grid.length==0)
            return res;

        int row = grid.length;
        int col = grid[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]=='1'){
                    res++;
                    mark(row, col, i, j, grid);
                }
            }
        }
        return res;
    }

    public static void mark(int row, int col, int i, int j, char[][] grid){
        // process current
        if(grid[i][j]=='1')
            grid[i][j] = '0';
        else
            return;                         // mind here. need to return if grid == 0
        // process up
        if(i-1>=0)
            mark(row, col, i-1, j, grid);
        // process down
        if(i+1<row)
            mark(row, col, i+1, j, grid);
        // process left
        if(j-1>=0)
            mark(row, col, i, j-1, grid);
        // process right
        if(j+1<col)
            mark(row, col, i, j+1, grid);
        return;
    }
}


