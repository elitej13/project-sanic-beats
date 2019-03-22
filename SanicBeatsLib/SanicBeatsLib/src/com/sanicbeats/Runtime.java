package com.sanicbeats;

import java.io.IOException;
import java.lang.Math;


public class Runtime {
	
	
	public static void main(String[] args) throws IOException{
		try
		{
			System.out.println("Beginning Test...");
			//Create another class for any methods you want to test and call them from here.			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally 
		{
			//Cleanup code if needed
			
			int [] a = new int [10];
			
			for (int i = 0; i < a.length; i ++) {
				a[i] = (int)(Math.random()*100);
				System.out.print(a[i] + "  " );
			}
			
			System.out.println();
			
			int [] b = reverise(a);
			
			for (int i = 0; i < b.length; i ++) {
				
				System.out.print(b[i] + "  " );
			}
			System.out.println();
			System.out.println("Test Complete.\nPress enter to exit.");
			System.in.read();
			
		}
		
		System.out.println("The sysyem finished and exicuted as indended");

	}

	public static int[] reverise(int[] a) {
		int [] b = new int [a.length];
		for (int i = 0; i < b.length; i ++) {
			int max = Theromax() / 2;
			int t = a[i] - max;
			b[i] = max - t;
			
		}
			
		return b;
			
	}
	
	public static int max (int[] a) {
		int t = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < t ) {
				t = a[i];
			}
			
		}
		
		return t;
	}
	
	public static int Theromax () {
		return 100;
	}
	
}
