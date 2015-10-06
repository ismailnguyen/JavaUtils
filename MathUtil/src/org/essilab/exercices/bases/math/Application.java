package org.essilab.exercices.bases.math;

import org.essilab.exercices.bases.math.interfaces.IMathUtil;


public class Application {
	public static void main(String[] args) {
		IMathUtil app = new MathUtil();
		
		System.out.println("absolute: " + app.absolute(-634));
		System.out.println("factorial: " + app.factorial(3));
		System.out.println("isEven: " + app.isEven(2));
		System.out.println("isPrime: " + app.isPrime(43));
		System.out.println("max: " + app.max(23, 4));
		System.out.println("nextPrime: " + app.nextPrime(35));
		System.out.println("pow: " + app.pow(2, 3));
		System.out.println("sqrt: " + app.sqrt(17, 3));
		System.out.println("pi: " + app.pi(44));
	}
}
