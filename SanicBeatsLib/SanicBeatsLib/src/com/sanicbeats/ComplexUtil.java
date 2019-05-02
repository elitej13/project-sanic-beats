package com.sanicbeats;

public class ComplexUtil {


	// makes the lows high and the highs low
	public static ComplexNumber[] reverse(ComplexNumber[] a) {
		ComplexNumber[] b = new ComplexNumber[a.length];
		for (int i = 0; i < b.length; i++) {
			ComplexNumber t = a[i].multiply(new ComplexNumber(-1,-1));
			b[i] = t;

		}
		return b;

	}
	

	// returns / compresses the array and gets the average of the array baised on
	// the number given
	public static ComplexNumber[] average(ComplexNumber[] b, int n) {
		ComplexNumber[] a = new ComplexNumber[b.length];
		ComplexNumber average = new ComplexNumber(0,0);
		int diff;
		for(int i = 0;i<b.length;i++) {
			if(i%n==0) {
			average = new ComplexNumber(0,0);
			diff=0;
			for(int j =0;j<n;j++) {
				if(j+i<a.length) {
					average = average.add(b[j+i]);
				}
				else {
					diff++;
				}
			}
			average =average.divide(new ComplexNumber(n-diff,0));
			}
			a[i]=new ComplexNumber(average);
		}
		
//		
//		
//		
//		double d = Math.ceil((double) (a.length) / n);
//		ComplexNumber[] b = new ComplexNumber[(int) d];
//		int j = 0;
//		for (int i = 0; i < a.length; i += n) {
//			ComplexNumber q = new ComplexNumber(0,0);
//			ComplexNumber t = new ComplexNumber(0,0);
//			for (int w = 0; w < n; w++) {
//				if ((w + i) < a.length) {
//					q.add(new ComplexNumber(1,0));
//					t.add(a[i + w]);
//				}
//				else {break;}
//			}
//			// always divides by the number given by n
//			b[j] = t.divide(q);
//			j++;
//		}

		return a;

	}

	// returns / compresses the array and gets the average of the array for every 2
	// spots
	public static ComplexNumber[] average2(ComplexNumber [] a) {
			ComplexNumber [] b = new ComplexNumber[(int)Math.ceil(a.length/2)];
			int j = 0;
			for (int i = 0; i < a.length; i+=2) {
				ComplexNumber t = new ComplexNumber (0,0);
				t = a[i].add(t);
				t= a[i+1].add(t);
				b[j] = t.divide(new ComplexNumber(2,0));
				j++;
			}
			return b;
			
		}
		
		//sets each spot of the array to a random values baised on the max value in the main array
		public static ComplexNumber[] random (ComplexNumber [] a) {
			ComplexNumber max = max(a);
			ComplexNumber [] b = new ComplexNumber [a.length];
			for (int i = 0; i < b.length; i++) {
				b[i] = (new ComplexNumber(Math.random(),0)).multiply(max);
				}
			return b;
			
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
