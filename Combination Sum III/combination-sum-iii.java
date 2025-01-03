class Solution {
    public void handle(int index, int n, int k, int sum, List<Integer> temp, List<List<Integer>> res) {
        if (sum == n && k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (sum > n || k == 0)
            return;
        
        for (int i = index; i <= 9; i++) {
            sum += i;
            k--;
            temp.add(i);
            handle(i + 1, n, k, sum, temp, res);
            temp.remove(temp.size() - 1);
            sum -= i;
            k++;
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        handle(1, n, k, sum, temp, res);
        return res;
    }
}
