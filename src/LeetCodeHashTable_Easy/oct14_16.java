import java.util.HashSet;

/*
 * 还没有AC!!!不知道为什么
 * 
 * 数独的规则：每行、每列和每个宫（即3x3的大格）均須包含 1～9，不能缺少，也不能重複
 * 参考：http://www.cnblogs.com/springfor/p/3884217.html
 * 
 * 
 * set清空：
 * map.clear()
 * 
 * HashSet<XX>:
 * 只含有一种类型元素，相当于这个set里面只存放值不相同的char
 * */
public class oct14_16 {
	public static void main(String[] args){
		// test goes here
	}
	
	public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length!=9 || board[0].length!=9)
        	return false;
        
        HashSet<Character> set = new HashSet<Character>();
        // check rows
        for(int i=0; i<9; i++){
        	for(int j=0; j<9; j++){
        		if(board[i][j] == '.')
        			continue;
        		if(set.contains(board[i][j]))
        			return false;
        		set.add(board[i][j]);
        	}
        	if(set.size()!=9)
        		return false;
        	set.clear();
        }
        
        // check cols
        for(int i=0; i<9; i++){
        	for(int j=0; j<9; j++){
        		if(board[j][i] == '.')
        			continue;
        		if(set.contains(board[j][i]))
        			return false;
        		set.add(board[j][i]);
        	}
        	if(set.size()!=9)
        		return false;
        	set.clear();
        }
        
        // check all 9*9 matrix
        for(int k=0; k<9; k++){
        	for(int i=0; i<3; i++){
        		for(int j=0; j<3; j++){
        			if(board[(k%3)*3+i][(k/3)*3+j] == '.')				// 重要：board[(k%3)*3+i][(k/3)*3+j] 找到第k个subgrid中 第i行j列的元素
        				continue;
        			if(set.contains(board[(k%3)*3+i][(k/3)*3+j]))
        				return false;
        			set.add(board[(k%3)*3+i][(k/3)*3+j]);
        		}
        		if(set.size()!=9)
        			return false;
        		set.clear();
        	}
        }
        
        return true;
    }
}
