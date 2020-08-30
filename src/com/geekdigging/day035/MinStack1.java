package com.geekdigging.day035;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2020/8/30
 * @Time: 18:57
 * @email: inwsy@hotmail.com
 * Description:
 */
public class MinStack1 {

    private Stack<Integer> data;
    private Stack<Integer> helper;

    /** initialize your data structure here. */
    public MinStack1() {
        data = new Stack<> ();
        helper = new Stack<> ();
    }

    public void push(int x) {
        data.push(x);
        // 辅助栈只会进栈小值
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.push(x);
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            int top = data.pop();
            // 只有当出栈的值也是小值的时候辅助栈也出栈
            if(top == helper.peek()){
                helper.pop();
            }
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，非法操作");
    }

    public int getMin() {
        if(!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
