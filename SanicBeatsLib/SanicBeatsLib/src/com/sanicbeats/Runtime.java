package com.sanicbeats;

import java.io.IOException;

public class Runtime {
	
	
	public static void main(String[] args) throws IOException
	{
		try
		{
			System.out.println("Beginning Test...");
			//Create another class for any methods you want to test and call them from here.			
			
			byte[] testybytes = {(byte)11000000,(byte)00010010,(byte)10000000,(byte)0010000};
			FFT.iterativeFFT(testybytes);
			
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
