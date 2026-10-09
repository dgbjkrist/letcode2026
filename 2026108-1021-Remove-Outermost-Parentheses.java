import java.util.*;

/*
A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

 

Example 1:

Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: s = "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
 

Constraints:

1 <= s.length <= 105
s[i] is either '(' or ')'.
s is a valid parentheses string.
 */
class Solution {
    public String removeOuterParentheses(String s) {
        int parenthesisDeep = 0;
        ArrayList<String> primitives = new ArrayList<String>();
        int lastPrimitiveIndex = 0;
        String result = "";

        for (int i=0; i<s.length(); i++)
        {
            char unit = s.charAt(i);
            if (unit == '(')
            {
                parenthesisDeep++;
            } else {
                parenthesisDeep--;
            }

            if (0 == parenthesisDeep)
            {
                primitives.add(s.substring(lastPrimitiveIndex, i+1));
                lastPrimitiveIndex = i+1;
            }
        }

        if (primitives.isEmpty())
        {
            return result;
        }

        ArrayList<String> outermostParenthesisRemoved = new ArrayList<String>();

        primitives.forEach(
            (primitive) -> {
                outermostParenthesisRemoved.add(primitive.substring(1, primitive.length() - 1));
            }
        );

        result = String.join("", outermostParenthesisRemoved);

        return result;







        
        // - je commence par regarder le 1er char, si c'est ouvert j'ajoute a openingParenthesisLength; il s'agit de la profondeur de la parenthses
        // - le 2eme, 
        // si c'est ouvert j'ajoute a openingParenthesisLength
        // si c'est fermé, 
        //      je verifie que openingParenthesisLength >= 0 ?
        //          si je decremente openingParenthesisLength (j'extrais que lorsque openingParenthesisLength = 0, il s'agit)
        //          sinon j'gnore
        // - le 3eme, 
        // si c'est ouvert j'ajoute a openingParenthesisLength
        // si c'est fermé, 
        //      je verifie que openingParenthesisLength > 0 ?
        //          si je decremente openingParenthesisLength
        //          sinon j'gnore
    }
}