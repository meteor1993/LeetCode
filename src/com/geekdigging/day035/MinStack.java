package com.geekdigging.day035;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * @Date: 2020/8/30
 * @Time: 13:59
 * @email: inwsy@hotmail.com
 * Description:
 */
public class MinStack {

    private Stack<Integer> data;
    private Stack<Integer> helper;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<> ();
        helper = new Stack<> ();
    }

    public void push(int x) {
        data.push(x);
        // 只有小于栈顶的数字才能进栈，否则重新将栈顶的数字进栈
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.push(x);
        } else {
            helper.push(helper.peek());
        }

    }

    public void pop() {
        if (!data.isEmpty()) {
            data.pop();
            helper.pop();
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
