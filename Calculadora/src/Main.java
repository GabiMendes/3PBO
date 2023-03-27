import br.edu.faeterj.Calculadora;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)    {
        Calculadora calculadora = new Calculadora();
        Scanner sc = new Scanner(System.in);

        System.out.println("Calculadora Jarvis, a calculadora feita em Java :) \n Regras de Uso: \n Insira primeiro valor, aperte Enter. \n Insira o operador, aperte Enter. \n Finalmente, insira o segundo valor e aperte Enter para ver o resultado.");
//        System.out.println("Valor 1:  ");
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
                sc.close();

            case '-':
                valor2 = sc.nextInt();

                int resultadoSub = Calculadora.Sub(valor1, valor2);

                System.out.println("Resultado:  " + resultadoSub);
                sc.close();

            case '/':
                valor2 = sc.nextInt();

                int resultadoDivi = Calculadora.Divi(valor1, valor2);

                System.out.println("Resultado:  " + resultadoDivi);
                sc.close();

            case '*':
                valor2 = sc.nextInt();

                int resultadoMult = Calculadora.Mult(valor1, valor2);

                System.out.println("Resultado:  " + resultadoMult);
                sc.close();

            case 'p':
                valor2 = sc.nextInt();

                int resultadoPot = Calculadora.Pot(valor1, valor2);

                System.out.println("Resultado:  " + resultadoPot);
                sc.close();

            case 'c':
                valor2 = sc.nextInt();

                System.out.println("" + valor1 + "" + valor2);

        }

    }
}