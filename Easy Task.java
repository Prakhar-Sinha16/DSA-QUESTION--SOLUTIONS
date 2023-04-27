gfg link: https://practice.geeksforgeeks.org/problems/c928f229cc972671d91c5e9f6b222414912cc88a/1

QUES:
Given a string s whose length is n and array queries of length q where each elements of queries is either of type 1 query or type 2 query which is explained ahead.

There are two types of query.

Query type 1 : ["1",ind,char]  "1" denotes this is type 1 query. In this query you have to change the character at index ind in s to character char.
(Data type of ind,char is string in input)

Query Type 2: ["2",left,right,k]  "2" denotes this is type 2 query. In this query you have to return kth lexographically largest character  in the subtring of s 
(it is the kth largest character in sorted order , not the kth distinct character) starting from index left and ending at index right both left and right are inclusive. (Data type of left,right,k is string in input)

You have to perform each query in the same order as given in  queries and return an array res such that res array contains the answer for each type2 query in same 
order as it appeared in queries.

Note : 0 based indexing is used.

Example 1:

Input:
n=4
s="abab"
q=2
queries={{"1","2","d"},{"2","1","3","1"}}
Output: 
{"d"}
Explanation:
First query is of type 1 so after changing character at index 2 
to d  s becomes abdb . Now Second query is of type 2 in which 
the 1st(k=1) lexographically largest character is "d" in substring "bdb"(s[1:3]). So we 
returned a array with result of type 2 query {"d"}.
Example 2:

Input:
n=3
s="aaa"
q=3
queries={{"1","1","e"},{"1","2","c"},{"2","1","2","2"}}
Output:
{"c"}
Explanation:
After applying first two queries s becomes aec. Now for 
the last query which is a type 2 second largest character 
in subtring s starting from index 1 to ending at index 2 is "c".
Your Task:
You don't need to read input or print anything. Your task is to complete the function easyTask() which takes an integer n,string s,an integer q and an array queries 
which contains  queries of type1 and type2  respectively and returns an array res such that res array contains the answer for each type2 query in same order as it 
appeared in queries.

Expected Time Complexity: O(N+(Q*logN))
Expected Space Complexity: O(N)


Constraints:
1<=n<=5*10^4
1<=q<=10^5
0<=int(left)<=int(right)<=n-1
0<=int(index)<=n-1
1<=int(k)<=right-left+1
s and char contains lowercase english letters
The sum of n over all test cases won't exceed 5*10^4.
  
CODE:
class Solution {
    public static ArrayList<Character> easyTask(int n,String s,int q,query queries[])
    {
        ArrayList<Character> aa = new ArrayList<>();
        StringBuffer sb = new StringBuffer(s);
        for(int i=0;i<q;i++){
            
            query queryx =queries[i];
            
            
            if(queryx.type=="1"){
                int idx= Integer.parseInt(queryx.a);
                sb.setCharAt(idx,(queryx.b).charAt(0));
                
            }else{
                int st=Integer.parseInt(queryx.a);
                int e=Integer.parseInt(queryx.b);
                int k=Integer.parseInt(queryx.c);
                
                String wrk = (sb.substring(st,e+1)).toString();
                lexoSort(aa,wrk,k);
            }
        }
        return aa;
    }
    
    public static void lexoSort(ArrayList<Character> aa ,String s,int k){
        int[] str = new int[26];
        for(char c : s.toCharArray() ){
            str[c-'a']++;
        }
        int count =k;
        int i=25;
        for(;i>=0;i--){
            count = count-str[i];
            
            if(count<=0) break;
        }
        
        aa.add((char)('a'+i));
    }
}
/*In case the query is of type 1.
type=1
c=null
*/

/*In case the query is of type 2.
type=2
c=k
*/

class query
{
    String type;
    String a;
    String b;
    String c;
    public query(String type,String a,String b,String c)
    {
        this.type=type;
        this.a=a;
        this.b=b;
        this.c=c;
    }
}
