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
     public double pi(int i) {
         double result = 0;
		 
         if(i == 0)
             i = 1;
		 
         for(int k = 0; k <= i; k++)
            result += pow(-1, k) / ((2.0*k) +1.0);
		 
         return 4.0 * result;
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
		if(arg0 < 0) return 0;
	  
		double num = arg0, upperbound;
		 
		float guess, e;
		 guess = 1;
		 e = 1/arg1;
		 do 
		 {
			 upperbound = num / guess;
			 guess = (float) ((upperbound + guess) / 2);
		 } while (!(guess * guess >= num - e && 
					guess * guess <= num + e));

		 return guess;
	 }

}
