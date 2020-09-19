package org.gmnz.hr;


import java.util.Stack;


public class QueueWithStacks {

    static class MyQueue<T> {

        private Stack<T> s1;
        private Stack<T> s2;

        public MyQueue() {
            s1 = new Stack<>(); // elemento più recente in cima
            s2 = new Stack<>(); // elemento più vecchio in cima
        }



        private void internalShift() {
            if (s2.isEmpty())
                while (!s1.isEmpty())
                    s2.push(s1.pop());
        }



        public void enqueue(T t) {
            s1.push(t);
        }



        public T dequeue() {
            internalShift();
            return s2.isEmpty() ? null : s2.pop();
        }



        public T peek() {
            internalShift();
            return s2.isEmpty() ? null : s2.peek();
        }
    }
}