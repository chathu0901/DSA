/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Submission03;

import java.util.EmptyStackException;

/**
 *
 * @author ncsur
 */
public class LinkedListStack<T> {
    
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node top = null;

    public void push(T data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T value = top.data;
        top = top.next;
        return value;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
    
}
