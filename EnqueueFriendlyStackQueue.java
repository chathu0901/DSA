/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day01_20251216;

import java.util.Stack;

/**
 *
 * @author ncsur
 */
public class EnqueueFriendlyStackQueue<T> {
    
     private Stack<T> input  = new Stack<>();
    private Stack<T> output = new Stack<>();

    
    public void enqueue(T data) {
        input.push(data);
    }

   
    public T dequeue() {
        checkEmpty();

        
        while (!input.isEmpty()) {
            output.push(input.pop());
        }

        
        T dequeued = output.pop();

        
        while (!output.isEmpty()) {
            input.push(output.pop());
        }

        return dequeued;
    }

    
    public T peek() {
        checkEmpty();

        while (!input.isEmpty()) {
            output.push(input.pop());
        }

        T front = output.peek();

        while (!output.isEmpty()) {
            input.push(output.pop());
        }

        return front;
    }

    public boolean isEmpty() {
        return input.isEmpty();
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
    }
    
}
