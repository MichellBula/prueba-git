/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;

import java.util.Scanner;

/**
 *
 * @author DELL-7040M
 */
public class PRUEBA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numero1 = 0;
		int numero2 = 0;
		int resultado;

		Scanner reader = new Scanner(System.in);
		
		System.out.println("Introduce el primer número:");			
		numero1 = reader.nextInt();
			
		System.out.println("Introduce el segundo número:");
		numero2 = reader.nextInt();
			
		// Sumamos
		resultado = numero1+numero2;
		
		System.out.println("La suma es " + numero1 + " + " + numero2 + " = " + resultado);
		
		reader.close();
			
    }
    
}
