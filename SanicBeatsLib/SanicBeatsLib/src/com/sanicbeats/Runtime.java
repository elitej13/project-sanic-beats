package com.sanicbeats;

import java.io.IOException;

public class Runtime {
	
	
	public static void main(String[] args) throws IOException
	{
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
			
			System.out.println("Test Complete.\nPress enter to exit.");
			System.in.read();
		}
	}
	
	
	
}
