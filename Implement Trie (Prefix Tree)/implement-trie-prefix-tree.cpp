class Trie {
public:
    bool isend;
    Trie* arr[26];
    Trie() {
        isend = false;
        for (int i = 0; i < 26; i++) {
            arr[i] = NULL;
        }
    }

    void insert(string word) {
        Trie* cur = this;
        for (char ch : word) {
            if (cur->arr[ch - 'a'] == NULL) {
                cur->arr[ch - 'a'] = new Trie();
            }
            cur = cur->arr[ch - 'a'];
        }
        cur->isend = true;
    }

    bool search(string word) {
        Trie* cur = this;
        for (char ch : word) {
            if (cur->arr[ch - 'a'] == NULL) {
                return false;
            }
            cur = cur->arr[ch - 'a'];
        }
        return cur->isend;
    }

    bool startsWith(string prefix) {
        Trie* cur = this;
        for (char ch : prefix) {
            if (cur->arr[ch - 'a'] == NULL) {
                return false;
            }
            cur = cur->arr[ch - 'a'];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */