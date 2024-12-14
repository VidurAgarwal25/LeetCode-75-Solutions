class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            long minPotion = (success + spells[i] - 1) / spells[i];
            int l = 0, r = potions.length;
            while (l < r) {
                int middle = l + (r - l) / 2;
                if (potions[middle] >= minPotion) {
                    r = middle;
                } else {
                    l = middle + 1;
                }
            }
            res[i] = potions.length - l;
        }
        return res;
    }
}
