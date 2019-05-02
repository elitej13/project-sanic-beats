package com.sanicbeats;

import java.util.Stack;
public class FFT {
	
	public static ComplexNumber[] iterativeFFT(byte[] bytes) {
		int[] a =new int[bytes.length];
		
		for(int i = 0;i<bytes.length;i++) {
			a[i]=bytes[i];
		}
		
		System.out.println("Before transform");
		for(int cn:a) {
			System.out.print(cn+" ");
		}
		System.out.println();
		
		int[] b = bitReverseCopy(a);
		ComplexNumber[] A = new ComplexNumber[a.length];
		for (int i = 0;i<a.length;i++) {
			A[i] = new ComplexNumber(b[i],0);
		}

//		System.out.println("before transform");
//		for(ComplexNumber cn:A) {
//			System.out.println(cn.toString());
//		}
		
		int n = a.length;
		//maybe issues here because of floating point math?
		int end = (int)(Math.log(n)/Math.log(2)/*+1e-10*/);
		int m;
		ComplexNumber omegam;
		ComplexNumber omega;
		ComplexNumber t;
		ComplexNumber u;
		for(int s = 1;s<=end;s++) {
			m=(int)Math.pow(2, s);
			omegam =new ComplexNumber(0 ,Math.pow(Math.E, 2*Math.PI/m));
			for(int k = 0;k<n;k+=m) {
				omega = new ComplexNumber(1,0);
				for(int j = 0;j<m/2;j++) {
					//System.out.println("before transform: A[k+j] "+A[k+j]+" A[k+j+m/2 "+A[k+j+m/2]);
					t=ComplexNumber.multiply(omega, A[k+j+m/2]);
					u=A[k+j];
					A[k+j] = ComplexNumber.add(u,t);
					A[k+j+m/2] = ComplexNumber.subtract(u,t);//add(new ComplexNumber(-t.real(),-t.imaginary()));
					
					//System.out.println("t: "+t+" u: "+u+" omega: "+omega);
					//System.out.println("after transform: A[k+j] "+A[k+j]+" A[k+j+m/2 "+A[k+j+m/2]);
					omega.multiply(omegam);
				}
			}
		}
		System.out.println("After transform");
		for(ComplexNumber cn:A) {
			System.out.print(" "+cn.toString());
		}
		System.out.println();
		
		//FAILURE
//		int lengthSqrt = (int)(Math.sqrt(bytes.length));
//		ComplexNumber[] B = new ComplexNumber[lengthSqrt];
//		for(int i = 0;i<B.length;i++) {
//			B[i]=A[i*lengthSqrt];
//		}
//		System.out.println("After after transform");
//		for(ComplexNumber cn:B) {
//			System.out.print(" "+cn.toString());
//		}
//		System.out.println();
		return A;
	}
	//-------------------------------------------------------------------
	//--------------reverse------------------
	public static byte[] reverseIterativeFFT(ComplexNumber[] A) {
		//int[] b = bitReverseCopy(a);
		//ComplexNumber[] A = new ComplexNumber[a.length];
//		for (int i = 0;i<a.length;i++) {
//			A[i] = new ComplexNumber(b[i],0);
//		}

//		System.out.println("before reverse transform");
//		for(ComplexNumber cn:A) {
//			System.out.println(cn.toString());
//		}
		
		
		//switch back to right length FAILURE
//		int lengthSqr =B.length*B.length;
//		ComplexNumber[] A = new ComplexNumber[lengthSqr];
//		int i2=0;
//		for(int i = 0;i<A.length;i++) {
//			if(i%B.length==0) {
//				A[i]=B[i2];
//				i2++;
//			}
//			else {
//				A[i]=new ComplexNumber(0,0);
//			}
//		}
		System.out.println("Before reversing");
		for(ComplexNumber cn:A) {
			System.out.print(" "+cn.toString());
		}
		System.out.println();
		int n = A.length;
		//maybe issues here because of floating point math?
		int end = (int)(Math.log(n)/Math.log(2)/*+1e-10*/);
		int m;
		ComplexNumber omegam;
		ComplexNumber omega;
		ComplexNumber t;
		ComplexNumber u;
		for(int s = end;s>=1;s--) {
			m=(int)Math.pow(2, s);
			omegam =new ComplexNumber(0 ,Math.pow(Math.E, 2*Math.PI/m));
			for(int k = n-m;k>=0;k-=m) {
				omega = new ComplexNumber(1);
				for(int j = 0;j<m/2;j++) {
					omega.multiply(omegam);
//					System.out.println("omega * omegam"+omega.toString());
				}
				for(int j = m/2-1;j>=0;j--) {
					omega.divide(omegam);
					//System.out.println("before reverse: A[k+j] "+A[k+j]+" A[k+j+m/2 "+A[k+j+m/2]);
					t=ComplexNumber.subtract(A[k+j],A[k+j+m/2]);
					t.divide(2.0);
					u=ComplexNumber.subtract(A[k+j],(t));
					A[k+j]=new ComplexNumber(u);
					A[k+j+m/2]=ComplexNumber.divide(t,omega);
//					System.out.println("t: "+t.toString()+" u: "+u.toString()+" omega: "+omega.toString());
					//System.out.println("after reverse: A[k+j] "+A[k+j]+" A[k+j+m/2 "+A[k+j+m/2]);
					
					
				}
			}
		}
//		System.out.println("After reverse transform");
//		for(ComplexNumber cn:A) {
//			System.out.println(cn.toString());
//		}
//		
		
		int[] a = new int[A.length];
		for (int i = 0;i<a.length;i++) {
			a[i] = (int)A[i].real();
			if(A[i].real()-a[i]>.5) {
				a[i]++;
			}
		}
		int[] b = bitReverseCopy(a);
		
		System.out.println("After reverse transform and bit reverse");

		for(int cn:b) {
			System.out.print(cn+" ");
		}
		System.out.println();
		
		byte[] newBytes =new byte[b.length];
		for(int i=0;i<b.length;i++) {
			newBytes[i]=(byte)b[i];
		}
		return newBytes;
	}
	
	
	
	
	
	
	
	
	
	//----------------------------------------------------------------------
	public static int[] bitReverseCopy(int[] a) {
		int[] newA = new int[a.length];
		//maybe issues here because of floating point math?
		int bitLength = (int)(Math.log(a.length)/Math.log(2)+1e-10);
		for (int i = 0;i<a.length;i++) {
			newA[rev(i,bitLength)]=a[i];
		}
		return newA;
	}
	
	//this method returns the binary reverse of a number
	public static int rev(int a,int bitLength) {
		//create boolean representation of binary num
		Stack<Boolean> bin= new Stack<Boolean>();
		//System.out.println("rev start: "+a);
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
		//System.out.println("rev should be 0: "+a);
		//create reverse of binary num
		a=0;
		int counter=1;
		while(!bin.isEmpty()) {
			if(bin.pop()) {
				a+=counter;
			}
			counter*=2;
		}

		//System.out.println("rev end: "+a);
		
		return a;
		
		
	}

}
