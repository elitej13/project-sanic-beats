package com.sanicbeats;

import java.util.Stack;
public class FFT {
	
	public static byte[] iterativeFFT(byte[] a) {
		byte[] b = bitReverseCopy(a);
		ComplexNumber[] A = new ComplexNumber[a.length];
		for (int i = 0;i<a.length;i++) {
			A[i] = new ComplexNumber(b[i],0);
		}

		System.out.println("before transform");
		for(ComplexNumber cn:A) {
			System.out.println(cn.toString());
		}
		
		int n = a.length;
		//maybe issues here because of floating point math?
		int end = (int)(Math.log(n)/Math.log(2));
		int m;
		ComplexNumber omegam;
		ComplexNumber omega;
		ComplexNumber t;
		ComplexNumber u;
		for(int s = 1;s<end;s++) {
			m=(int)Math.pow(2, s);
			omegam =new ComplexNumber(0 ,Math.pow(Math.E, 2*Math.PI/m));
			for(int k = 0;k<n;k+=m) {
				omega = new ComplexNumber(1,0);
				for(int j = 0;j<m/2;j++) {
					t=omega.multiply(A[k+j+m/2]);
					u=A[k+j];
					A[k+j] = u.add(t);
					A[k+j+m/2] = u.add(new ComplexNumber(-t.real(),-t.imaginary()));
					omega = omega.multiply(omegam);
				}
			}
		}
		System.out.println("After transform");
		for(ComplexNumber cn:A) {
			System.out.println(cn.toString());
		}
		
		return b;
	}
	public static byte[] bitReverseCopy(byte[] a) {
		byte[] newA = new byte[a.length];
		//maybe issues here because of floating point math?
		int bitLength = (int)(Math.log(a.length)/Math.log(2));
		for (int i = 0;i<a.length;i++) {
			newA[rev(i,bitLength)]=a[i];
		}
		return newA;
	}
	
	//this method returns the binary reverse of a number
	public static int rev(int a,int bitLength) {
		//create boolean representation of binary num
		Stack<Boolean> bin= new Stack<Boolean>();
		System.out.println("rev "+a);
		for(int i = 0;i<bitLength;i++) {
		//while(a>0) {
			if (a%2==1) {
				bin.push(true);
			}
			else {
				bin.push(false);
			}
			a/=2;
		}
		System.out.println("rev "+a);
		//create reverse of binary num
		a=0;
		int counter=1;
		while(!bin.isEmpty()) {
			if(bin.pop()) {
				a+=counter;
			}
			counter*=2;
		}

		System.out.println("rev "+a);
		return a;
		
		
	}

}
