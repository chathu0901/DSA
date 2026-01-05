/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Submission03;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ncsur
 */
public class RabbitProblem<T> {
    
    private Map<Integer, Integer> memo = new HashMap<>();

    public int rabbitPairs(int month) {
        if (month == 0) return 0;
        if (month == 1) return 1;

        if (memo.containsKey(month)) {
            return memo.get(month);
        }

        int result = rabbitPairs(month - 1) + rabbitPairs(month - 2);
        memo.put(month, result);
        return result;
    }

    public static void main(String[] args) {
        RabbitProblem<Integer> rp = new RabbitProblem<>();
        int months = 10;

        System.out.println("Rabbit pairs after " + months + " months: "
                + rp.rabbitPairs(months));
    }
    
}
