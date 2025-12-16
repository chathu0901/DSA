/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day01_20251216;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ncsur
 */
public class PopFriendlyQueueStack<T> {
    
    private Queue<T> main   = new LinkedList<>();
    private Queue<T> buffer = new LinkedList<>();

    
    public void push(T data) {
        buffer.offer(data);

        while (!main.isEmpty()) {
            buffer.offer(main.poll());
        }

        swapQueues();
    }

    
    public T pop() {
        checkEmpty();
        return main.poll();
    }

    
    public T peek() {
        checkEmpty();
        return main.peek();
    }

    public boolean isEmpty() {
        return main.isEmpty();
    }

    private void swapQueues() {
        Queue<T> temp = main;
        main = buffer;
        buffer = temp;
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
    }
    
}
