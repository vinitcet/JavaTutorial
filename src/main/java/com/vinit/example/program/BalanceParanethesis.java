package com.vinit.example.program;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BalanceParanethesis {
    public static void main(String[] args) {
        Boolean balanced = true;
        String s = "({[{}]})";
        Stack<Character> st = new Stack<>();
        Deque dq = new ArrayDeque();
        List<Character> charList = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        for (Character c : charList) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else if (c == ')') {
                char check = st.pop();
                {
                    if (check != '(') {
                        balanced = false;
                        break;
                    }
                }
            }else if (c == '}') {
                char check = st.pop();
                {
                    if (check != '{') {
                        balanced = false;
                        break;
                    }
                }
            }else if (c == ']') {
                char check = st.pop();
                {
                    if (check != '[') {
                        balanced = false;
                        break;
                    }
                }
            }
        }
        System.out.println("It is balanced "+balanced);

    }
}
