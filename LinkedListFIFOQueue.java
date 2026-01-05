/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Submission03;

/**
 *
 * @author ncsur
 */
public class LinkedListFIFOQueue<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node front = null;
    private Node rear = null;
    private int size = 0;

    public void enqueue(T data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }

        T value = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public static void main(String[] args) {
        LinkedListFIFOQueue<Integer> queue = new LinkedListFIFOQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println("Size: " + queue.size());
    }
    
}
