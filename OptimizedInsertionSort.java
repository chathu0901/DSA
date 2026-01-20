/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Submission05;

/**
 *
 * @author ncsur
 */
public class OptimizedInsertionSort {
    
    public static void optInsertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift only when needed (optimized)
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 4, 3};
        optInsertionSort(arr);

        for (int x : arr)
            System.out.print(x + " ");
    }
    
}
