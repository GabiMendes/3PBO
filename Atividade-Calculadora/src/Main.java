package br.edu.faeterj;
import br.edu.faeterj.Calculadora;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args)    {
        Scanner sc = new Scanner(System.in);
        double valor1 = 0;
        double valor2 = 0;
        String operador = "";
        
       System.out.println("Valor1: ");
       
       valor1 = sc.nextInt();
       
       sc.nextLine();
       
       System.out.println("Operador: ");
      	operador = sc.nextLine();
      	
       System.out.println("Valor2: ");
       valor2 = sc.nextInt();
        
        double resultado = Calculadora.DecideOperacao(valor1, valor2, operador);
        System.out.println("resultado x " + operador + " y =" + resultado);
        

    sc.close();
    
    }
}
