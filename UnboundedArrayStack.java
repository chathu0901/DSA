/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day01_20251216;

/**
 *
 * @author ncsur
 */
public class UnboundedArrayStack<T> {
    
    private static final int DEFAULT_CAPACITY = 2;
    private T[] stack;
    private int top;

    @SuppressWarnings("unchecked")
    public UnboundedArrayStack() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    public void push(T data) {
        if (top == stack.length - 1) {
            resize(stack.length * 2);
        }
        stack[++top] = data;
    }

    public T pop() {
        checkEmpty();

        T popped = stack[top];
        stack[top--] = null;

        if (top >= 0 && top == stack.length / 4) {
            resize(stack.length / 2);
        }

        return popped;
    }

    public T peek() {
        checkEmpty();
        return stack[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newStack = (T[]) new Object[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, top + 1);
        stack = newStack;
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
    }
    
}
