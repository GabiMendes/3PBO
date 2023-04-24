package br.edu.faeterj;

public class Triangulo {
	public double a, b, c;
	
	public double CalculaArea()
	{
		double p = (a + b + c)/2.0;
		double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		
		return area;
	}
}
