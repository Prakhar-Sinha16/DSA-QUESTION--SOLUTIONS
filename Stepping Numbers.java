gfg link=> https://practice.geeksforgeeks.org/problems/stepping-numberswrong-output1813/1

int ans;
    int steppingNumbers(int n, int m){
        // code here
        ans=0;
        if(n==0)ans++;
        for(int i=1;i<=9;i++){
            dfs(i,n,m);
        }
        return ans;
    }
    
    void dfs(int current, int n, int m){
        if(current > m)return;
        if(current>=n && current<=m)ans++;
        int lastDigit = current%10;
        if(lastDigit==9){
            dfs(current*10+8,n,m);
        }else if(lastDigit==0){
            dfs(current*10+1,n,m);
        }else{
            dfs(current*10+(lastDigit+1),n,m);
            dfs(current*10+(lastDigit-1),n,m);
        }
    }
