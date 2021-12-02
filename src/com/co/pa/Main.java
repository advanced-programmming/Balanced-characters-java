package com.co.pa;

import java.util.ArrayDeque;
import java.util.Deque;

/*      "(()()())" -> balanced
        “()()” -> balanced
        "(()(()()()" -> not balanced
        "(()(()())" -> not balanced
        ")()(()" -> not balanced
        “())(()” -> not balanced
        "()())(" -> not balanced
    * */
public class Main {
    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    public static void main(String[] args) {
        String value = "()())(";
        System.out.printf(String.valueOf(balanced(value)));
    }

    public static boolean balanced(String chain){
        Deque<Character> deque = new ArrayDeque<>();
        if(chain.charAt(0) == CLOSE || chain.charAt(chain.length() - 1) == OPEN) return false;

        for(int i = 0; i < chain.length(); i++){
            if(chain.charAt(i) == OPEN) deque.addFirst(chain.charAt(i));
            else {
                if(deque.isEmpty()) deque.addLast(chain.charAt(i));
                else deque.removeFirst();
            }
        }

        return deque.isEmpty();
    }
}
