package org.gmnz.hr;


import java.util.Stack;


public class QueueWithStacks {

    static class MyQueue<T> {

        private enum Operation {
            NONE, PUSH, POP_OR_PEEK;
        }

        private Stack<T> s1;
        private Stack<T> s2;
        private Operation lastOperation;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }



        public void enqueue(T t) {
            if (lastOperation == Operation.POP_OR_PEEK)
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            s1.push(t);
            lastOperation = Operation.PUSH;
        }



        public T dequeue() {
            if (lastOperation == Operation.POP_OR_PEEK) {
                return s2.size() > 0 ? s2.pop() : null;
            } else
                while (s1.size() > 1) {
                    s2.push(s1.pop());
                }
            lastOperation = Operation.POP_OR_PEEK;
            return s1.size() > 0 ? s1.pop() : null;
        }



        public T peek() {
            if (lastOperation != Operation.POP_OR_PEEK) {
                while (s1.size() > 0) {
                    s2.push(s1.pop());
                }
                lastOperation = Operation.POP_OR_PEEK;
            }
            return s2.size() > 0 ? s2.peek() : null;
        }

    }

    public static void main(String[] args) {

    }
}