class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions,
                                long long success) {
        vector<int> res;
        sort(potions.begin(), potions.end());
        for (int i = 0; i < spells.size(); i++) {
            int spell = spells[i];
            long long minpotion = (success+spell-1)/spell;
            int l = 0;
            int r = potions.size(), index = 0;
            while (l < r) {
                int middle = l + (r - l) / 2;
                if (potions[middle] >= minpotion) {
                    r = middle;
                } else
                    l = middle + 1;
            }
            res.push_back(potions.size()-l);
        }
        return res;
    }
};