gfg link: https://practice.geeksforgeeks.org/problems/task-scheduler/1

QUES:
Given a character array tasks of size N, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks 
could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just 
be idle.
CPU has a cooldown period for each task. CPU can repeat a task only after atleast K units of time has passed after it did same task last 
time. It can perform other tasks in that time, can stay idle to wait for repeating that task.

Return the least number of units of times that the CPU will take to finish all the given tasks.

Example 1:

Input:
N = 6
K = 2
task[ ] = {'A', 'A', 'A', 'B', 'B', 'B'}
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is atleast 2 units of time between any two same tasks.
 
Example 2:

Input:
N = 12
K = 2
task[ ] = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}
Output: 16
Explanation:  
One possible solution is 
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function leastInterval() which takes the interger N, integer 
K and an character array tasks as parameters and returns the minimum unit of time required to complete all tasks.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 104
0 ≤ K ≤ 100
taski is upper-case English letter.

CODE:
class Solution {
    static class Pair{
        char ch;
        int fre;
        Pair(char ch, int fre){
            this.ch = ch;
            this.fre = fre;
        }

    }
    static int leastInterval(int N, int K, char tasks[]) {
        // code here
        if(K == 0) return tasks.length;
        
        HashMap<Character, Integer> map = new HashMap<>();
        LinkedList<Pair> list= new LinkedList<>();
        
        for(char c : tasks) map.put(c, map.getOrDefault(c, 0)+1);
        for(char c : map.keySet()) list.add(new Pair(c, map.get(c)));
        
        Collections.sort(list, (Pair p1, Pair p2)->p2.fre-p1.fre);
        int idle = (list.get(0).fre-1)*K;
        for(int i = 1 ; i < list.size() ; i++){
            idle = idle - Math.min(list.get(i).fre, list.get(0).fre-1);
        }
        return tasks.length+Math.max(idle, 0);
    }
}
