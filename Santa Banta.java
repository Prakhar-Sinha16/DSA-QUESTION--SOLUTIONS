gfg link: https://practice.geeksforgeeks.org/problems/santa-banta2814/1

QUES:
Santa is still not married. He approaches a marriage bureau and asks them to hurry the process. The bureau checks the list of eligible 
girls of size N and hands it over to Santa. Santa being conscious about his marriage is determined to find a girl with maximum 
connections so that he can gather more information about her. Accordingly, he looks to figure out the maximum number of girls 
(from the list) who know each other to achieve the above purpose.

In order to finalize the girl, he needs to find the Kth prime. Where k = largest group of girls who know each other. Considering Santa's
poor knowledge of Maths, he seeks Banta's help for the answer. Now you, a fan of Santa Banta Jokes, take this prestigious opportunity to solve the problem.

In case no of connections is zero, print "-1". Here the connection between girls is represented by a 2-D array g of dimension M*2, where
M is the number of connections.

Note :
1. Suppose girl "a" knows girl "b" and girl "b" knows girl "c", then girl "a" also knows girl "c". Transitivity holds here.
2. Consider 1 as a composite number.
3. For precompute function given in the template you just have to complete it and use it wherever required, do not call it again and 
again, it is already being called by driver function before executing test cases. 

Example 1:

Input : 
N = 10
M = 6
g[] = {{1,2},{2,3},{3,4},{4,5},{6,7},{9,10}}
Output : 
11
Explanation:
Here in this graph there are 4 groups. 
In 1st group: (1 -> 2 -> 3 -> 4 -> 5) are 
there. In 2nd group: (6 -> 7) are there.
In 3rd group: (8) is there.
In 4th group: (10 -> 9) are there.
In these 4 group the maximum number of 
value is 5. So, K = 5 and the 5th prime number 
is 11. Return 11.
Example 2:

Input : 
N = 2
M = 1
g[] = {{1, 2}} 
Output : 
3
Explanation:
In this Example there will only be a 
single group of 2 girls, and hence the 
value of K is 2, The 2nd prime is 3.
Your Task:

This is a function problem. The input is already taken care of by the driver code. You only need to complete the function helpSanta() 
that takes a number of girls (n), a number of connections (m), a 2-D array of girls connections (g), and return the Kth prime no if 
there are no connections then return -1. The driver code takes care of the printing.

Expected Time Complexity: O(N + M).
Expected Auxiliary Space: O(N + M).

Constraints:
1 ≤ n ≤ 105
0 ≤ m ≤ 105
1 ≤ u, v ≤ n
Sum of n+m will not exceed 105.
  
CODE:
class Complete{
    private static final List<Integer> primes = new ArrayList<>();
    private static final int MAX_SIZE = 1_000_000_1;
    public static void precompute () {
        boolean[] isPrime = new boolean[MAX_SIZE];
        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1]=false;
        for(int i = 2; i < MAX_SIZE; i++){
            if(isPrime[i]){
                for(long j = (long)i*i; j < MAX_SIZE; j+= 2*i){
                    isPrime[(int)j] = false;
                }
            }
        }
        primes.add(2);
        for(int i = 3; i < MAX_SIZE; i+=2){
            if(isPrime[i]){
                primes.add(i);
            }
        }
    }
    // Function for finding maximum and value pair
    public static int helpSanta (int n, int m, int g[][]) {
        List<List<Integer>> graph = buildGraph(n,g);
        boolean[] visited = new boolean[n+1];
        int groupSize = 0;
        for(int node = 1; node<=n; node++){
            if(!visited[node]){
                groupSize = Math.max(dfs(node,graph,visited),groupSize);
            }
        }
        return groupSize <= 1 ? -1 : primes.get(groupSize-1);
    }
    
    private static int dfs(int p,List<List<Integer>> graph,boolean[] visited){
        visited[p] = true;
        int count = 1;
        for(int c : graph.get(p)){
            if(!visited[c]){
                count += dfs(c,graph,visited);
            }
        }
        return count;
    }
    
    private static List<List<Integer>> buildGraph(int n,int g[][]){
        List<List<Integer>> graph= new ArrayList<>();
        for(int i = 0; i <= n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] edge : g){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
    
    
}
