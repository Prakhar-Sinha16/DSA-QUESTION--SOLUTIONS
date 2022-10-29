gfg link => https://practice.geeksforgeeks.org/problems/phone-directory4628/1

//QUES: Given a list of contacts contact[] of length n where each contact is a string which exist in a phone directory and a query string s. The task is to implement a search query for the phone directory. Run a search query for each prefix p of the query string s (i.e. from  index 1 to |s|) that prints all the distinct contacts which have the same prefix as p in lexicographical increasing order. Please refer the explanation part for better understanding.
// Note: If there is no match between query and contacts, print "0".

// Example 1:

// Input: 
// n = 3
// contact[] = {"geeikistest", "geeksforgeeks", 
// "geeksfortest"}
// s = "geeips"
// Output:
// geeikistest geeksforgeeks geeksfortest
// geeikistest geeksforgeeks geeksfortest
// geeikistest geeksforgeeks geeksfortest
// geeikistest
// 0
// 0
// Explaination: By running the search query on 
// contact list for "g" we get: "geeikistest", 
// "geeksforgeeks" and "geeksfortest".
// By running the search query on contact list 
// for "ge" we get: "geeikistest" "geeksforgeeks"
// and "geeksfortest".
// By running the search query on contact list 
// for "gee" we get: "geeikistest" "geeksforgeeks"
// and "geeksfortest".
// By running the search query on contact list 
// for "geei" we get: "geeikistest".
// No results found for "geeip", so print "0". 
// No results found for "geeips", so print "0".
// Your Task:
// Youd do not need to read input or print anything. Your task is to complete the function displayContacts() which takes n, contact[ ] and s as input parameters and returns a list of list of strings for required prefixes. If some prefix has no matching contact return "0" on that list.

// Expected Time Complexity: O(|s| * n * max|contact[i]|)
// Expected Auxiliary Space: O(n * max|contact[i]|)

// Constraints:
// 1 ≤ T ≤ 100, T = number of test cases
// 1 ≤ n ≤ 50
// 1 ≤ |contact[i]| ≤ 50
// 1 ≤ |s| ≤ 6 

//CODE: 
//In this solution we had used HashSet & at last we had sorted temp.
//Total Time Taken: 0.37
class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n,String contact[], String s){
        // code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(String string : contact)set.add(string);
        String word="";
        for(int i=0;i<s.length();i++){
            word += s.charAt(i);
            ArrayList<String> temp = new ArrayList<>();
            for(String a : set){
                if(i>=a.length())continue;
                else if(word.equals(a.substring(0,i+1))){
                    temp.add(a);
                }
            }
            if(temp.size()==0)temp.add("0");
            Collections.sort(temp);
            ans.add(temp);
        }
        return ans;
    }
  
  //SOLUTION 2:
  //In this solution we had used TreeSet which can optimize above code as no sorting is req in TreeSet
  //Total Time Taken: 0.38
  class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n,String contact[], String s){
        // code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Set<String> set = new TreeSet<>();
        for(String string : contact)set.add(string);
        String word="";
        for(int i=0;i<s.length();i++){
            word += s.charAt(i);
            ArrayList<String> temp = new ArrayList<>();
            for(String a : set){
                if(i>=a.length())continue;
                else if(word.equals(a.substring(0,i+1))){
                    temp.add(a);
                }
            }
            if(temp.size()==0)temp.add("0");
            ans.add(temp);
        }
        return ans;
    }
}
}
