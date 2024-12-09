class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                r.add(i);
            } else {
                d.add(i);
            }
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int rId = r.poll();
            int dId = d.poll();
            if (rId < dId) {
                r.add(rId + n);
            } else {
                d.add(dId + n);
            }
        }

        return r.size() > d.size() ? "Radiant" : "Dire";
    }
}
