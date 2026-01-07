/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Submission04;

/**
 *
 * @author ncsur
 */
public class HanoiTower {
    
    static void hanoi(int n, char from, char to, char aux) {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        hanoi(n - 1, aux, to, from);
    }

    public static void main(String[] args) {
        int disks = 3;
        hanoi(disks, 'A', 'C', 'B');
    }
    
}
