// GFG LINK => https://practice.geeksforgeeks.org/problems/print-diagonally4331/1
// Ques=> Give a N * N square matrix A, return all the elements of its anti-diagonals from top to bottom.

static ArrayList<Integer> downwardDigonal(int n, int a[][])
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<=n+n-2;i++){
            for(int j=0;j<n;j++){
                if(i-j >=0 && (i-j)<n){
                    ans.add(a[j][i-j]);
                }
            }
        }
        return ans;
    }
