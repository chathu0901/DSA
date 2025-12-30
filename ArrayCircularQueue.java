/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Submission02;

/**
 *
 * @author ncsur
 */
public class ArrayCircularQueue<T> {
    
    private T[] queue;
    private int front, rear, size, capacity;

    @SuppressWarnings("unchecked")
    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity]; 
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T data) {
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
    }

    public T dequeue() {
        T data = queue[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        ArrayCircularQueue<Integer> cq = new ArrayCircularQueue<>(3);

        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);

        System.out.println(cq.dequeue()); // 1
        cq.enqueue(4);
        System.out.println(cq.dequeue()); // 2
        System.out.println(cq.dequeue()); // 3
        System.out.println(cq.dequeue()); // 4
    }
    
}
