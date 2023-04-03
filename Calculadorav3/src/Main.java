import br.edu.faeterj.Calculadora;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)    {

        Calculadora calc = new Calculadora();
        Scanner sc = new Scanner(System.in);

        long raizArredondada = 0;

        System.out.println("Calculadora Jarvis, a calculadora feita em Java :) \n Regras de Uso: \n Insira primeiro valor, aperte Enter. \n Insira o operador, aperte Enter. \n Finalmente, insira o segundo valor e aperte Enter para ver o resultado. \n Informações Úteis: c - concatenação, p - potência, r - raiz, t - cálculos trigonométricos. ");

        double resultadoRaiz = 0;
        int valor1 = 0;
        int valor2 = 0;
        String svalor2 = "";

        valor1 = sc.nextInt();

        sc.nextLine();

        char operador = sc.next().charAt(0);

        sc.nextLine();

        switch(operador)
        {
            case '+':

                valor2 = sc.nextInt();

                int resultadoSoma = calc.Soma(valor1, valor2);

                System.out.println("Resultado:  " + resultadoSoma);

                break;

            case '-':

                valor2 = sc.nextInt();

                int resultadoSub = calc.Sub(valor1, valor2);

                System.out.println("Resultado:  " + resultadoSub);

                break;

            case '/':

                valor2 = sc.nextInt();

                int resultadoDivi = calc.Divi(valor1, valor2);

                System.out.println("Resultado:  " + resultadoDivi);

                break;

            case '*':

                valor2 = sc.nextInt();

                int resultadoMult = calc.Mult(valor1, valor2);

                System.out.println("Resultado:  " + resultadoMult);

                break;

            case 'p':

                valor2 = sc.nextInt();

                int resultadoPot = calc.Pot(valor1, valor2);

                System.out.println("Resultado:  " + resultadoPot);

                break;

            case 'r':

                valor2 = sc.nextInt();

                calc.Raiz(valor1, valor2);

                resultadoRaiz = calc.Raiz(valor1, valor2);

                if(Math.round(resultadoRaiz)==resultadoRaiz)
                {
                    System.out.println("Resultado:  " + resultadoRaiz);
                }
                else
                {
                    System.out.println("Resultado:  não possui raíz redonda. ");
                }

                break;

            case 'c':

                valor2 = sc.nextInt();

                System.out.println("" + valor1 + "" + valor2);

                break;

            case 't':

                System.out.println("Digite S para Seno, C para Cosseno e T para Tangente:  ");

                svalor2 = sc.next();

                double resultadoTrig = calc.Trig(valor1, svalor2);

                System.out.println("Resultado:  " + resultadoTrig);

                break;

        }

    sc.close();

    }
}