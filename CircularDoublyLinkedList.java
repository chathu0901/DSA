/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Submission03;

/**
 *
 * @author ncsur
 */
public class CircularDoublyLinkedList<T> {
    
    private class Node {
        T data;
        Node prev, next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head = null;
    private int size = 0;

    // Insert at end
    public void insert(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node tail = head.prev;

            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
        size++;
    }

    // Delete a node by value
    public boolean delete(T data) {
        if (head == null) return false;

        Node current = head;
        do {
            if (current.data.equals(data)) {
                if (current.next == current) { // only one node
                    head = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    if (current == head) {
                        head = current.next;
                    }
                }
                size--;
                return true;
            }
            current = current.next;
        } while (current != head);

        return false;
    }

    public int size() {
        return size;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<>();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display();

        list.delete(20);
        list.display();

        System.out.println("Size: " + list.size());
    }
    
}
