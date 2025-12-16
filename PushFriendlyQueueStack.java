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
public class PushFriendlyQueueStack<T> {
    
    private Queue<T> primary = new LinkedList<>();
    private Queue<T> helper  = new LinkedList<>();

    
    public void push(T data) {
        primary.offer(data);
    }

    
    public T pop() {
        checkEmpty();

        while (primary.size() > 1) {
            helper.offer(primary.poll());
        }

        T popped = primary.poll();
        swapQueues();
        return popped;
    }

    
    public T peek() {
        checkEmpty();

        while (primary.size() > 1) {
            helper.offer(primary.poll());
        }

        T top = primary.poll();
        helper.offer(top);
        swapQueues();
        return top;
    }

    public boolean isEmpty() {
        return primary.isEmpty();
    }

    private void swapQueues() {
        Queue<T> temp = primary;
        primary = helper;
        helper = temp;
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
    }
    
}
