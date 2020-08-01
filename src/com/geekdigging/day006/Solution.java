package com.geekdigging.day006;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution {

    public boolean isValid(String s) {
        if (s.length() == 0) return true;

        if (s.length() % 2 == 1) return false;

        Stack<Character> stack = new Stack<> ();

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);

            // 如果是左括号，则把字符压入栈
            if (charAt == '(' || charAt == '{' || charAt == '[')
                stack.push(charAt);
            else {
                // 如果此时还有右括号而栈中已无左括号
                if (stack.isEmpty()) return false;
                // 获取栈顶的值
                char top = stack.peek();
                // 如果栈顶的值等于右括号，则出栈，否则返回 false
                if ((top == '{' && charAt == '}') || (top == '(' && charAt == ')') || (top == '[' && charAt == ']'))
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private Map<Character, Character> map;

    // 初始化哈希表
    public Solution() {
        this.map = new HashMap<>();
        this.map.put(')', '(');
        this.map.put('}', '{');
        this.map.put(']', '[');
    }


    public boolean isValid_1(String s) {
        if (s.length() == 0) return true;

        if (s.length() % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            // 如果不是右括号，则把字符压入栈
            if (!this.map.containsKey(charAt)) {
                stack.push(charAt);
            } else {
                // 如果此时还有右括号而栈中已无左括号
                if (stack.isEmpty()) return false;
                // 获取栈顶的值
                char top = stack.peek();
                // 如果栈顶的值等于右括号，则出栈，否则返回 false
                if (top == this.map.get(charAt))
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.empty();
    }

    public boolean isValid_2(String s) {
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chs) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String strs = "()";
        System.out.println(solution.isValid(strs));
    }
}
