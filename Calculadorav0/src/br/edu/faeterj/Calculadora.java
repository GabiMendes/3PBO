package br.edu.faeterj;

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


}
