import br.edu.faeterj.Calculadora;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)    
    {
        
        Calculadora calculadora = new Calculadora();
        Scanner sc = new Scanner(System.in);

        System.out.println("Calculadora Jarvis, a calculadora feita em Java :) \n Regras de Uso: \n Insira primeiro valor, aperte Enter. \n Insira o operador, aperte Enter. \n Finalmente, insira o segundo valor e aperte Enter para ver o resultado.");

        int valor1 = 0;
        int valor2 = 0;
        valor1 = sc.nextInt();

        char operador = sc.next().charAt(0);

        switch(operador)
        {
            case '+':
                valor2 = sc.nextInt();

                int resultadoSoma = Calculadora.Soma(valor1, valor2);

                System.out.println("Resultado:  " + resultadoSoma);
                
                break;
               

            case '-':
                valor2 = sc.nextInt();

                int resultadoSub = Calculadora.Sub(valor1, valor2);

                System.out.println("Resultado:  " + resultadoSub);
                
                break;
 

            case '/':
                valor2 = sc.nextInt();

                int resultadoDivi = Calculadora.Divi(valor1, valor2);

                System.out.println("Resultado:  " + resultadoDivi);
                
                break;


            case '*':
                valor2 = sc.nextInt();

                int resultadoMult = Calculadora.Mult(valor1, valor2);

                System.out.println("Resultado:  " + resultadoMult);
                
                break;


            case 'p':
                valor2 = sc.nextInt();

                int resultadoPot = Calculadora.Pot(valor1, valor2);

                System.out.println("Resultado:  " + resultadoPot);
                
                break;


            case 'c':
                valor2 = sc.nextInt();

                System.out.println("" + valor1 + "" + valor2);
                
                break;

        }

    }
     sc.close();
}
