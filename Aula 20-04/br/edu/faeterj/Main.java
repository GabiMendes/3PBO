package br.edu.faeterj;
import java.util.Scanner;

public class Main {

	public static void main (String[] args)
	{
	Scanner sc = new Scanner (System.in);	
//	double xA, xB, xC, yA, yB, yC;
	
	Triangulo triX = new Triangulo();
	Triangulo triY = new Triangulo();
	
	System.out.println("Digite os lados do triângulo x:  ");
	triX.a = sc.nextDouble();
	triX.b = sc.nextDouble();
	triX.c = sc.nextDouble();
	
	System.out.println("Digite os lados do triângulo y:  ");
	triY.a = sc.nextDouble();
	triY.b = sc.nextDouble();
	triY.c= sc.nextDouble();
	
//	double px = (triX.a + triX.b + triX.c)/2;
//	double areax = Math.sqrt(px*(px-triX.a)*(px-triX.b)*(px-triX.c));
	double areaX = triX.CalculaArea();
	
//	double py = (triY.a + triY.b + triY.c)/2;
//	double areay = Math.sqrt(py*(py-triY.a)*(py-triY.b)*(py-triY.c));
	double areaY = triY.CalculaArea();
	
	System.out.println("Area do triangulo x:  " + areaX);
	System.out.println("Area do triangulo x:  " + areaY);
	
	sc.close();
	}

}
