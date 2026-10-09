import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int result = minAddToMakeValid("(())))");
        System.out.println(result);
    }


/*
A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

 

Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3
 

Constraints:

1 <= s.length <= 1000
s[i] is either '(' or ')'.
 */
    public static int minAddToMakeValid(String s) {
        // 1- compter le nombre de parenthesis
        int slength = s.length();
        // 2- determiner le nombre de parenthesis opening
        int oplength = 0;
        String openingParenthesis = "(";
        int openingParenthesisIsToComplete = 0;
        int closingParenthesisIsToComplete = 0;
        for (int i=0; i<s.length(); i++)
        {
            char parenthesisAtIPosition = s.charAt(i);
            if(parenthesisAtIPosition == openingParenthesis.charAt(0))
            {
                //parenthesisToComplete = 0
                // a- si le 1er open, j'incremente parenthesisToComplete
                closingParenthesisIsToComplete++;
                //b- si ya pas 2eme => je return parenthesisToComplete
                //c- si le 2eme est ouvert => je verifie 
                //d- si le 2eme est fermer => je decremente parenthesisToComplete et ça annule et on reprend a-

                //z- si le 1er close => j'incremente parenthesisToComplete et je le return
            }
            
            if (parenthesisAtIPosition != openingParenthesis.charAt(0)) {
                if (i == 0) {
                    openingParenthesisIsToComplete++;
                } else if (closingParenthesisIsToComplete > 0) {
                    closingParenthesisIsToComplete--;
                } else {
                    openingParenthesisIsToComplete++;
                }
                // si le 1er ferme => parenthesisToComplete++
                // next => on reprend a-
            }
        }
        return closingParenthesisIsToComplete + openingParenthesisIsToComplete;
    }
}
