package LeetCodeOtherAlgo;

/**
 * Created by luoshalin on 12/30/15.
 */
public class medium211 {
    class TrieNode{
        boolean have;
        TrieNode[] son;

        public TrieNode(){
            have = false;
            son = new TrieNode[26];
        }
    }

    public class WordDictionary {
        private TrieNode root;

        public WordDictionary(){
            root = new TrieNode();
        }

        // Adds a word into the data structure.
        public void addWord(String word) {
            if(word==null || word.length()==0)
                return;

            TrieNode curNode = root;
            for(int i=0; i<word.length(); i++){
                int pos = word.charAt(i) - 'a';
                if(curNode.son[pos]==null) {
                    curNode.son[pos] = new TrieNode();
                }
                curNode = curNode.son[pos];
            }
            curNode.have = true;
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            TrieNode curNode = root;
            int len = word.length();
            return dfs(root, word, 0, len);
        }
        private boolean dfs(TrieNode node, String word, int pos, int len){
            if(node==null || (pos==len && !node.have))
                return false;
            if(pos==len && node.have)
                return true;
            if(word.charAt(pos)=='.'){
                for(int i=0; i<26; i++){
                    boolean res = dfs(node.son[i], word, pos+1, len);
                    if(res)
                        return res;
                }
                return false;
            }
            else{
                int c = word.charAt(pos) - 'a';
                return dfs(node.son[c], word, pos+1, len);
            }
        }
    }
}
