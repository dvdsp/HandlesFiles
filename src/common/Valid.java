/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Valid {
    public static String checkInputPathFile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter path file(format: [namefile].txt): ");
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.print("Can not be empty. Let's try enter again:        ");
            } else {
                return result;
            }
        }
    }

    
    public static double checkInputMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter money: ");
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Must be input double. Enter again:  ");              
            }
        }
    }
    
    
    
    
    
    
    
}
