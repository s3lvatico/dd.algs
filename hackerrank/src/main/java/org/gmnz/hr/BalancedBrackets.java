package org.gmnz.hr;


import java.util.Stack;


public class BalancedBrackets {

    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else
                if (c == ')' && !stack.isEmpty() && stack.peek().charValue() == '(') {
                    stack.pop();
                } else
                    if (c == ']' && !stack.isEmpty() && stack.peek().charValue() == '[') {
                        stack.pop();
                    } else
                        if (c == '}' && !stack.isEmpty() && stack.peek().charValue() == '{') {
                            stack.pop();
                        } else
                            return "NO";
            // questo tiene conto del fatto che potrei arrivare alla fine della scansione
            // della stringa con uno stack non vuoto.
            // accade quando la stringa è bilanciata fin quasi alla fine, e poi l'ultimo
            // carattere è una qualche parentesi aperta: la logica sopra spinge comunque la
            // parentesi sullo stack, ma la stringa a questo punto è finita, e non è
            // bilanciata, quindi è necessario un ulteriore controllo sullo stack
            if (!stack.isEmpty() && i == s.length() - 1)
                return "NO";

        }
        return "YES";

    }

}