/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Submission02;

import java.util.Stack;

/**
 *
 * @author ncsur
 */
public class StackQueueDequeueFriendly<T> {
    
    private Stack<T> main_stack = new Stack<>();
    private Stack<T> aux_stack = new Stack<>();

    // Enqueue operation (O(n))
    public void enqueue(T data) {

        // Step 1: Move all elements from main_stack to aux_stack
        while (!main_stack.isEmpty()) {
            aux_stack.push(main_stack.pop());
        }

        // Step 2: Push new element into main_stack
        main_stack.push(data);

        // Step 3: Move all elements back to main_stack
        while (!aux_stack.isEmpty()) {
            main_stack.push(aux_stack.pop());
        }
    }

    // Dequeue operation (O(1))
    public T dequeue() {
        if (main_stack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return main_stack.pop();
    }

    // Peek front element
    public T peek() {
        if (main_stack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return main_stack.peek();
    }

    public boolean isEmpty() {
        return main_stack.isEmpty();
    }

    public static void main(String[] args) {
        StackQueueDequeueFriendly<Integer> queue = new StackQueueDequeueFriendly<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.dequeue()); // 20
        System.out.println(queue.dequeue()); // 30
    }
    
}
