package LeetCodeOtherAlgo;

/**
 * Created by luoshalin on 12/30/15.
 */
public class medium208 {
    class TrieNode {
        // Initialize your data structure here.
        int num;
        TrieNode[] son;
        char val;
        boolean isEnd;

        public TrieNode() {
            this.num = 1;
            this.son = new TrieNode[26];
            this.isEnd = false;
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            if(word==null || word.length()==0)
                return;

            char letters[] = word.toCharArray();
            TrieNode node  = this.root;
            for(int i=0; i<letters.length; i++){
                int pos = letters[i] - 'a';
                if(node.son[pos] == null){
                    TrieNode newNode = new TrieNode();
                    newNode.val = letters[i];
                    node.son[pos] = newNode;
                }
                else{
                    node.son[pos].num++;
                }
                node = node.son[pos];
            }
            node.isEnd = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            if(word==null || word.length()==0)
                return false;

            char letters[] = word.toCharArray();
            TrieNode curNode  = this.root;
            for(int i=0; i<letters.length; i++){
                int pos = letters[i] - 'a';
                if(curNode.son[pos] != null){
                    curNode = curNode.son[pos];
                }
                else{
                    return false;
                }
            }
            return curNode.isEnd;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if(prefix==null || prefix.length()==0)
                return false;

            char letters[] = prefix.toCharArray();
            TrieNode curNode  = this.root;
            for(int i=0; i<letters.length; i++){
                int pos = letters[i] - 'a';
                if(curNode.son[pos] != null){
                    curNode = curNode.son[pos];
                }
                else {
                    return false;
                }
            }
            return true;
        }
    }

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
}
