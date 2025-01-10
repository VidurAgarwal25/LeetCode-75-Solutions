class Trie(object):

    def __init__(self):
        """
        Initialize the Trie with a flag `is_end` and a dictionary `children`.
        """
        self.is_end = False
        self.children = {}

    def insert(self, word):
        """
        Inserts a word into the Trie.
        :type word: str
        :rtype: None
        """
        current = self
        for char in word:
            if char not in current.children:
                current.children[char] = Trie()
            current = current.children[char]
        current.is_end = True

    def search(self, word):
        """
        Searches for a word in the Trie.
        :type word: str
        :rtype: bool
        """
        current = self
        for char in word:
            if char not in current.children:
                return False
            current = current.children[char]
        return current.is_end

    def startsWith(self, prefix):
        """
        Checks if there is any word in the Trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        current = self
        for char in prefix:
            if char not in current.children:
                return False
            current = current.children[char]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
