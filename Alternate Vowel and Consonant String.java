gfg link => https://practice.geeksforgeeks.org/problems/alternate-vowel-and-consonant-string2939/1

//QUES: Given a string S of lowercase english characters. Rearrange characters of the given string such that the vowels and consonants occupy alternate positions and 
//the string so formed should be lexicographically (alphabetically) smallest. 
// Note: Vowels are 'a', 'e', 'i', 'o' and 'u'. 

// Example 1:

// Input:
// S = "aeroplane"
// Output: alanepero
// Explanation: alanepero  
// The vowels and cosonants are arranged 
// alternatively with vowels shown in bold.
// Also, there's no lexicographically smaller
// string possible with required conditions.
// Example 2:

// Input: 
// S = "mississippi"
// Output: -1
// Explanation: The number of vowels is 4 
// whereas the number of consonants is 7.
// Hence, there's no way to arrange the
// vowels and consonants alternatively.

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function rearrange() which takes the string S and its size N as inputs and returns 
//the modified string as stated in the description. If such a modification is not possible, return the string "-1".


// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(2*26).


// Constraints:
// 1 <= N <= 10^6
// 'a' <= S[ i ] <= 'z'

//CODE:
class Solution{
    public String rearrange(String S, int N){
        int[]vowels=new int[26];
        int[]consonants =new int[26];
        int noOfVowels=0;
        int noOfCons=0;
        char smallestVowel='u';
        char smallestCons='z';

        for(char c:S.toCharArray()){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                vowels[c-'a']++;
                noOfVowels++;
                smallestVowel=(char)Math.min((int)smallestVowel,(int)c);
            }else{
                consonants[c-'a']++;
                noOfCons++;
                smallestCons=(char)Math.min((int)smallestCons,(int)c);
            }
        }

        if(Math.abs(noOfVowels-noOfCons)>1)return "-1";

        boolean isVowel=false;

        if(noOfVowels>noOfCons){
            isVowel=true;
        }else if(noOfCons>noOfVowels){
            isVowel=false;
        }else{
            if(smallestVowel<smallestCons){
                isVowel=true;
            }else{
                isVowel=false;    
            }
        }

        StringBuilder sb=new StringBuilder();
        int i=0;
        int j=0;
        while(i<26 && j<26){
            if(isVowel){
                while(i<26 && vowels[i]==0)i++;
                if(i==26)break;
                sb.append((char)('a'+i));
                vowels[i]--;
                isVowel=false;
            }else{
                while(j<26 && consonants[j]==0)j++;
                if(j==26)break;
                sb.append((char)('a'+j));
                consonants[j]--;
                isVowel=true;
            }
        }
        return sb.toString();
    }
}
