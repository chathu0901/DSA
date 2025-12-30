/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Submission02;

/**
 *
 * @author ncsur
 */
public class DoublyLinkedList<T> {
    
    class Node {
        T data;
        Node prev, next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;

    public void insert(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    public void delete(T key) {
        if (head == null) return;

        Node temp = head;

        if (temp.data.equals(key)) {
            head = temp.next;
            if (head != null) head.prev = null;
            return;
        }

        while (temp != null && !temp.data.equals(key)) {
            temp = temp.next;
        }

        if (temp != null) {
            temp.prev.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
        }
    }

    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.insert(1);
        list.insert(2);
        list.insert(3);

        list.displayForward(); // 1 <-> 2 <-> 3 <-> null
        list.delete(2);
        list.displayForward(); // 1 <-> 3 <-> null
    }
    
}
