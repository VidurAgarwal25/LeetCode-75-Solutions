import java.util.*;

class SmallestInfiniteSet {

    private Set<Integer> s;
    private int cur;

    public SmallestInfiniteSet() {
        s = new TreeSet<>();
        cur = 1;
    }
    
    public int popSmallest() {
        if (!s.isEmpty()) {
            int firstElement = s.iterator().next();
            s.remove(firstElement);
            return firstElement;
        }
        return cur++;
    }
    
    public void addBack(int num) {
        if (num < cur) {
            s.add(num);
        }
    }
}


/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */