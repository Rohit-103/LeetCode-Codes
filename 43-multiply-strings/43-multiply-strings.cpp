class Solution {
public:
    string reverse(string s){
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++; j--;
        }
        return s;
    }
    string multiply_(string a, char c, int n=0){
        int carry = 0;
        string ans(n,'0');
        int y = c-'0';
        for(int i=0;i<a.length();i++){
            int x = a[i] - '0';
            int dig = (x*y)%10 + carry;
            ans.push_back(char(dig+'0'));
            carry = (x*y)/10;
        }
        if(carry) ans.push_back(char(carry+'0'));
        return ans;
    }
    string add(string a, string b){
        int i = 0;
        int carry = 0;
        int m = max(a.length(),b.length());
        string ans  = "";
        while(i<m){
            int x = (i >= a.length() ? 0 : a[i] - '0');
            int y = (i >= b.length() ? 0 : b[i] - '0');
            int sum = x + y + carry;
            int dig = sum%10;
            ans.push_back(char(dig + '0'));
            carry = sum/10;
            i++;
        }
        if(carry>0) ans.push_back('1');
        return ans;
    }
    string multiply(string num1, string num2) {
        string n1 = reverse(num1);
        string n2 = reverse(num2);
        string ans = "0";
        for(int i = 0; i < n2.length() ; i++){
            if(n2[i] == '0') continue;
            string s2 = multiply_(n1,n2[i],i);
            ans = add(ans,s2);
        }
        int j = ans.length()-1;
        while(j>=0 && ans[j] == '0')
            { ans.pop_back(); j--;}
        if(ans == "") return "0";
         return reverse(ans);
    }
};