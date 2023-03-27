package br.edu.faeterj;

public class Main 
{
	public static void main (String[] args)
	{
		System.out.println("Olá, mundo!");
		
		int  inteiro = 10;
        long longo = 123456789;
        float valor = 12.34f;
        double valorF = 34.56;
        char carac = 'g';
        boolean ehSim = true;
        
        String nome = "Justin Bieber";
        
        int result = 5 + 2 * 3 / 4;
        System.out.println(result);
        
        double resultD = 5 + 2 * 3 / 4;
        System.out.println(resultD);
        
        Scanner sc = new Scanner(System.in);
        
        String outroNome;
        
        System.out.println("Seu nome, por favor");
        outroNome = sc.next();
        System.out.println("Nome digitado foi: " + outroNome);
        
        System.out.println("Entre com o primeiro valor da soma:  ");
        
        int valor1 = 0;
        int valor2 = 0;
        
        valor1 = sc.nextInt() ;
        
        System.out.println("Entre com o segundo valor da soma:  ");
        
        valor2 = sc.nextInt();
        
        int resultadoInt = valor1 + valor2;
        System.out.println("O resultado é:  " + resultadoInt);
        
        sc.close();
        
        
	}
}