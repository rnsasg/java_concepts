class TrieNode{
    TrieNode[] child;
    boolean isEnd;

    public TrieNode(){
        child = new TrieNode[27];
        isEnd = false;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);

            if( cur.child[ch-'a'] == null){
                cur.child[ch-'a'] = new TrieNode();
            }
            cur = cur.child[ch-'a'];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            
            if( ch != '.' && cur.child[ch-'a'] == null) {
                return false;
            }

            cur = cur.child[ch-'a'];
        }

        return cur != null && cur.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */