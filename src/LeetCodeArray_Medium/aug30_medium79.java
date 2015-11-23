/*
 * 题意：给一个字母构成的二阶矩阵，求一个单词能不能在矩阵中出现（像贪吃蛇那样找词语）
 * 参考：http://www.cnblogs.com/springfor/p/3883942.html
 * 思路：感觉好难啊没思路啊！！
 * 		考察的是DFS遍历图。DFS对上下左右进行遍历；同时维护visited数组
 * 		这里的递归比较难理解，需要后面多复习几遍
 * 
 * 		1. 遍历数组中的每个元素。遍历到某个元素则表示用这个元素作为单词的首字母，开始上下左右递归寻找
 * 		2. 递归结果（true）：找到的词长＝＝目标词词长，则return true，结束递归 同时结束step1遍历循环
 * 		3. 递归结果（false）：越界or访问过了or字母不对，return false，结束当前这轮遍历循环，返回step1遍历下一个元素。如果当前矩阵元素等于要找的字符串内容，则进行step4
 * 		4. 递归公式：对当前元素的上下左右元素执行递归函数：先将当前位置置为visited，执行完递归一层层挑出来的时候置为unvisited
 * 
 * 要点：1. 如何获取String中某一位置的char？s.charAt(i)
 * 		2. 如何定义一个String: String word = new String("ab")
 * */
public class aug30_medium79 {
	public static void main(String[] args){
		char[][] board = {{'a'}};
		String word = new String("ab");
		System.out.println(exist(board, word));
	}
	
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n]; // to log each position: whether visited or not
        
        // step 1
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		if(dfs(board, word, 0, i, j, visited))
        			return true;
        	}
        }
        return false;
    }
    
    // 字符矩阵、目标字符串、当前寻找的是目标字符串的第几个字符、从矩阵中哪里开始寻找、visited矩阵
    public static boolean dfs(char[][] board, String word, int index, int rowindex, int colindex, boolean[][] visited){
    	// step 2
    	if(index == word.length())
    		return true;
    	
    	// step 3
    	if(rowindex<0 || colindex<0 || rowindex>=board.length || colindex>=board[0].length)
    		return false;
    	if(visited[rowindex][colindex])
    		return false;
    	if(board[rowindex][colindex]!=word.charAt(index))
    		return false;
    	
    	// step 4
    	visited[rowindex][colindex] = true;
    	boolean res = (    dfs(board, word, index+1, rowindex-1, colindex, visited)		// up
    					|| dfs(board, word, index+1, rowindex+1, colindex, visited)		// down
    					|| dfs(board, word, index+1, rowindex, colindex-1, visited)		// left
    					|| dfs(board, word, index+1, rowindex, colindex+1, visited));	// right
    	visited[rowindex][colindex] = false; // 一层层跳出来，当前这个位置被还原为unvisited
    	return res;   	
    }
}
