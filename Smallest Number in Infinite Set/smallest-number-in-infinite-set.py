import heapq

class SmallestInfiniteSet(object):

    def __init__(self):
        self.s = set()
        self.cur = 1

    def popSmallest(self):
        if self.s:
            firstElement = min(self.s)
            self.s.remove(firstElement)
            return firstElement
        else:
            self.cur += 1
            return self.cur - 1

    def addBack(self, num):
        if num < self.cur:
            self.s.add(num)


# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)