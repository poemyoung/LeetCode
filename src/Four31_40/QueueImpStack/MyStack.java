package Four31_40.QueueImpStack;

import java.util.LinkedList;

/**
 * 用队列模拟栈
 */
public class MyStack {
    LinkedList<Integer>queue ;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        //记录要弹出的个数
        int size = queue.size();
        //从头部弹出并加入尾部
        queue.add(x);
        for (int i = 0; i< size;i++){
            queue.add(queue.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek() == null ? 0 : queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        int size = queue.size();
        return size == 0;
    }
}
