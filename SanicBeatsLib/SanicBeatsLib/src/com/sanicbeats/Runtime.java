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
			
			int [] b = average(a,6);
			
			for (int i = 0; i < b.length; i ++) {
				
				System.out.print(b[i] + "  " );
			}
			System.out.println();
			System.out.println("Test Complete.\nPress enter to exit.");
			System.in.read();
			
		}
		
		System.out.println("The sysyem finished and exicuted as indended");

	}

	//makes the lows high and the highs low
	public static int[] reverise(int[] a) {
		int [] b = new int [a.length];
		for (int i = 0; i < b.length; i ++) {
			int max = Theromax() / 2;
			int t = a[i] - max;
			b[i] = max - t;
			
		}
			
		return b;
			
	}
	
	//returns / compresses the array and gets the average of the array for every 2 spots
	public static int[] average2(int [] a) {
		int [] b = new int  [(int)Math.ceil(a.length/2)];
		int j = 0;
		for (int i = 0; i < a.length; i+=2) {
			int t = 0;
			t = a[i] + t;
			t= a[i+1] + t;
			b[j] = (int)Math.ceil(t/2);
			j++;
		}
		
		return b;
		
	}
	
	//returns / compresses the array and gets the average of the array baised on the number given
	public static int[] average(int [] a, int n) {
		double d = Math.ceil((double)(a.length)/n);
		int [] b = new int  [(int)d];
		int j = 0;
		for (int i = 0; i < a.length; i+=n) {
			int q = 0;
			int t = 0;
			for (int w = 0; w < n; w++) {
				if ((w+i) < a.length ) {
					q++;
					t = a[i+w] + t;
				}
			}
			// always divides by the number given by n
			b[j] = (int)Math.ceil(t/q);
			j++;
		}
		
		return b;
		
	}
	//sets each spot of the array to a random values baised on the max value in the main array
	public static int[] random (int [] a) {
		int max = max(a);
		int [] b = new int [a.length];
		for (int i = 0; i < b.length; i++) {
			b[i] = (int)Math.random()*max;
			}
		return b;
		
	}
	
	// gets the max value in the given array
	public static int max (int[] a) {
		int t = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < t ) {
				t = a[i];
			}
			
		}
		
		return t;
	}
	
	
	
	// may be used later
	public static int Theromax () {
		return 100;
	}
	
	// returns a random movie quote
	public static void movie() {
		int a = (int)Math.random()*8;
		if (a == 0 ) {
			System.out.println("'They may take our lives, but they'll never take our freedom!' - Braveheart");
		}
		else if (a == 1) {
			System.out.println("'When you realize you want to spend the rest of your life with somebody, you want the rest of your life to start as soon as possible.' - When Harry Met Sally");
		}
		else if (a == 2) {
			System.out.println("'If you let my daughter go now, that'll be the end of it. I will not look for you, I will not pursue you. But if you don't, I will look for you, I will find you, and I will kill you.' - Taken");
		}
		else if (a == 3) {
			System.out.println("Roads? Where we're going we don't need roads.' -Back to the Future");
		}
		else if (a == 4) {
			System.out.println("'Hello. My name is Inigo Montoya. You killed my father. Prepare to die.' The Princess Bride");
		}
		else if (a == 5) {
			System.out.println("' Mawage. Mawage is wot bwings us togeder today. Mawage, that bwessed awangment, that dweam wifin a dweam...' - The Princess Bride");
		}
		else if (a == 6) {
			System.out.println("'It is not our abilities that show what we truly are… it is our choices.' – Harry Potter and the Chamber of Secrets");
		}
		else if (a == 7) {
			System.out.println("'My momma always said, 'Life is like a box of chocolates, you never know what you’re gonna get.'' – Forrest Gump");
		}
		else if (a == 8) {
			System.out.println("'How many times do I have to teach you: just because something works doesn’t mean it can’t be improved.' — Black Panther");
		}
	}
}
