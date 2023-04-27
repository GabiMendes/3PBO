package br.edu.faeterj;
import java.util.Objects;
import java.util.Scanner;

public class Calculadora
{
	public static double DecideOperacao(double valor1, double valor2, String op)
	{
	
	double resultado = 0;
	 double resultadoRaiz = 0;
     String svalor2 = "";
    long raizArredondada = 0;
    
	
	switch(op)
    {
        case "+":

            resultado = Calculadora.Soma(valor1, valor2);

            break;

        case "-":

            resultado = Calculadora.Sub(valor1, valor2);

            break;

        case "/":

            resultado = (float)Calculadora.Divi(valor1, valor2);

            break;

        case "*":

            resultado = Calculadora.Mult(valor1, valor2);

            break;

        case "p":

            resultado = Calculadora.Pot(valor1, valor2);

            break;

        case "r":

            Calculadora.Raiz(valor1, valor2);

            resultadoRaiz = Calculadora.Raiz(valor1, valor2);

            if(Math.round(resultadoRaiz)==resultadoRaiz)
            {
            	resultado=(int)resultadoRaiz;
            }
            else
            {
                resultado=-1;
            }

            break;

        case "t":

            System.out.println("Digite S para Seno, C para Cosseno e T para Tangente:  ");
            Scanner sc = new Scanner(System.in);
            svalor2 = sc.next();

            resultado = (int)Calculadora.Trig(valor1, svalor2);

            break;

    }
	
	return resultado;
	
	}
	
    private static double Soma(double valor1, double valor2)
    {
        return valor1+valor2;
    }

    private static double Mult(double valor1, double valor2)
    {
        return valor1*valor2;
    }

    private static double Divi(double valor1, double valor2)
    {
        return valor1/valor2;
    }

    private static double Sub(double valor1, double valor2)
    {
        return valor1-valor2;
    }

    private static int Pot(double valor1, double valor2)
    {
        return (int) Math.pow(valor1, valor2);
    }

    private static double Raiz(double valor1, double valor2)
    {
        double ResultadoRaiz = Math.pow(valor1,(1/valor2));

        return (double) Math.pow(valor1,(1/valor2));

    }

    private static double Trig(double valor1, String b )
    {
        double angRad = valor1 * Math.PI / 180;
        double resultado = 0;

        if((Objects.equals(b, "S"))||(Objects.equals(b, "s")))
        {
            resultado = Math.sin(angRad);
        }
        else if ((Objects.equals(b, "C"))||(Objects.equals(b, "c")))
        {
            resultado = Math.cos(angRad);
        }
        else if ((Objects.equals(b, "T"))||(Objects.equals(b, "t")))
        {
            resultado = Math.tan(angRad);
        }

        return resultado;

    }


}
