package com.sanicbeats;

import java.io.IOException;

public class Runtime {
	
	
	public static void main(String[] args) throws IOException
	{
		try
		{
			System.out.println("Beginning Test...");
			//Create another class for any methods you want to test and call them from here.			
			
			int[] testybytes = {255,4,67,34,2,35,40,4,255,4,67,34,2,35,40,4,255,4,67,34,2,35,40,4,255,4,67,34,2,35,40,4};
					
			ComplexNumber[] A = FFT.iterativeFFT(testybytes);
			FFT.reverseIterativeFFT(A);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally 
		{
			//Cleanup code if needed
			
			System.out.println("Test Complete.\nPress enter to exit.");
			System.in.read();
			
		}
		
		
		
	}
	

	
	
	
}
