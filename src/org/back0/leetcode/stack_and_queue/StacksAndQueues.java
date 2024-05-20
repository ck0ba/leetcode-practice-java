package org.back0.leetcode.stack_and_queue;

import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks/description/

public class StacksAndQueues {
    private final Stack<Integer> enqueueStack;
    private final Stack<Integer> dequeueStack;

    public StacksAndQueues() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void push(int x) {
        enqueueStack.push(x);
    }

    public int pop() {
        ensureOrderForPop();

        return dequeueStack.pop();
    }

    public int peek() {
        ensureOrderForPop();

        return dequeueStack.peek();
    }

    public boolean empty() {
        return enqueueStack.empty() && dequeueStack.empty();
    }

    private void ensureOrderForPop() {
        if (dequeueStack.empty()) {
            while (!enqueueStack.empty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
    }
}
