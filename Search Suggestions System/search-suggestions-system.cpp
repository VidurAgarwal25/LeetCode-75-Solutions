class Solution {
public:
    vector<vector<string>> suggestedProducts(vector<string>& products, string searchWord) {
        sort(products.begin(),products.end());
        vector<vector<string>> res;
        string cur="";
        for(char ch: searchWord){
            cur+=ch;
            auto left=lower_bound(products.begin(),products.end(),cur);
            auto right=upper_bound(products.begin(),products.end(),cur+'~');
            vector<string>temp;int count=0;
            for(auto i=left;i!=right;i++){
                temp.push_back(*i);
                count++;
                if(count==3)
                break;
            }
            res.push_back(temp);
        }
        return res;
    }
};