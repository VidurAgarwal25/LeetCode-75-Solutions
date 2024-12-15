class SmallestInfiniteSet {
public:
    set<int> s;
    int cur;
    SmallestInfiniteSet() { cur = 1; }

    int popSmallest() {
        if(s.size()){
            int firstelement = *s.begin();
            s.erase(firstelement);
            return firstelement;
        }
        return cur++;
    }

    void addBack(int num) {
        if(num<cur){
            s.insert(num);
        }
    }
};

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet* obj = new SmallestInfiniteSet();
 * int param_1 = obj->popSmallest();
 * obj->addBack(num);
 */