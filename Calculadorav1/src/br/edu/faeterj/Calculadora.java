package br.edu.faeterj;

import java.util.Objects;

public class Calculadora
{
    public static int Soma(int a, int b)
    {
        return a+b;
    }

    public static int Mult(int a, int b)
    {
        return a*b;
    }

    public static int Divi(int a, int b)
    {
        return a/b;
    }

    public static int Sub(int a, int b)
    {
        return a-b;
    }

    public static int Pot(int a, int b)
    {
        return (int) Math.pow(a, b);
    }

    public static double Raiz(float a, float b)
    {
        double ResultadoRaiz = Math.pow(a,(1/b));

        return (double) Math.pow(a,(1/b));

    }

    public static double Trig(int a, String b )
    {
        double angRad = a * Math.PI / 180;
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
