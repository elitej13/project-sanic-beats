package com.sanicbeats;

public class ComplexUtil {


	// makes the lows high and the highs low
	public static ComplexNumber[] reverse(ComplexNumber[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i].multiply(-1);

		}
		return a;

	}
	

	// returns / compresses the array and gets the average of the array based on
	// the number given
	public static ComplexNumber[] average(ComplexNumber[] a, int n) {
		ComplexNumber average = new ComplexNumber(0);
		int diff;
		for(int i = 0;i<a.length;i++) {
			if(i%n==0) {
			average.x=0;
			average.y=0;
			diff=0;
			for(int j =0;j<n;j++) {
				if(j+i<a.length) {
					average.add(a[j+i]);
				}
				else {
					diff++;
				}
			}
			average.divide(new ComplexNumber(n-diff,0));
			}
			a[i]=new ComplexNumber(average);
		}

		return a;

	}

		
		//sets each spot of the array to a random values based on the max value in the main array
		public static ComplexNumber[] random (ComplexNumber [] a) {
			ComplexNumber max = max(a);
			for (int i = 0; i < a.length; i++) {
				a[i]=new ComplexNumber(max);
				a[i].multiply(Math.random());
				}
			return a;
			
		}
		
		// gets the max value in the given array
		public static ComplexNumber max (ComplexNumber[] a) {
			ComplexNumber t = new ComplexNumber(Double.MIN_VALUE,Double.MIN_VALUE);
			for (int i = 0; i < a.length; i++) {
				if (a[i].isGreaterThan(t)) {
					t = a[i];
				}
			}
			return t;

		}


}
