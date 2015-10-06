package org.essilab.exercices.bases.math;

import org.essilab.exercices.bases.math.interfaces.IMathUtil;

public class MathUtil implements IMathUtil {

	@Override
	public int absolute(int arg0) {
		return arg0>=0 ? arg0 : arg0 * (-1);
	}

	@Override
	public long factorial(int arg0) {
		long l = 1;
		for (int i=1; i<=arg0; i++)
			l *= i;
		return l;
	}

	@Override
	public boolean isEven(int arg0) {
		return arg0 % 2 == 0 ? true : false;
	}

	@Override
	public boolean isPrime(int arg0) {
		if(arg0 == 2)return true;
		if(arg0 % 2 == 0) return false;
		for(int i=3; i*i<=arg0; i+=2)
			if(arg0 % i == 0) return false;
		return true;
	}

	@Override
	public int max(int arg0, int arg1) {
		return arg0>arg1 ? arg0 : arg1;
	}

	@Override
	public long nextPrime(int arg0) {
		int i = arg0;
		for(; i<2*arg0; ++i)
		{
			if(this.isPrime(i))
				return i;
		}
		
		return 0;
	}

	@Override
	public double pi(int arg0) {
		double denom = 3.0;
		double num = 1.0;
		boolean operator = false;
		int power = arg0;
		
		 for (int x = 0; x < 21; x++) {
			 if (operator == false) {
				 num -= (1.0/(denom*(this.pow(3, power))));
				 operator = true;
			 }
			 else {
				 num += (1.0/(denom*(this.pow(3, power))));
				 operator = false;
			 }
			 denom += 2;
			 power += 1;
		 }
		 
		 return this.sqrt(12, 1) * num;
	}

	@Override
	public long pow(int arg0, int arg1) {
		long l = 1;
		for(int i=1; i<=arg1; i++)
			l *= arg0;
		return l;
	}

	@Override
	public double sqrt(double arg0, int arg1) {
		double a, b, m, x; 
	      if(arg0==0.0) {
	         return 0.0;
	      }
	      else {
	         m=1.0; 
	         x=arg0; 
	         while(x>=2.0) {
	            x=0.25*x; 
	            m=2.0*m;
	         }
	         while(x<0.5) {
	            x=4.0*x; 
	            m=0.5*m; 
	         }
	         a=x; 
	         b=1.0-x; 
	         do { 
	            a=a*(1.0+0.5*b); 
	            b=0.25*(3.0+b)*b*b; 
	         } while(b>=1.0E-15); 
	         
	         return a*m;
	      }
	}

}
