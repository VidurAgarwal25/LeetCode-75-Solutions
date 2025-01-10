class Trie {
    private boolean isEnd;
    private Trie[] children;

    public Trie() {
        isEnd = false;
        children = new Trie[26];
    }

    public void insert(String word) {
        Trie current = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Trie();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        Trie current = this;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie current = this;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
