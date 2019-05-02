package com.sanicbeats;

public class Util {
	
	//makes the lows high and the highs low
		public static byte[] reverse(byte[] a) {
			byte [] b = new byte [a.length];
			for (long i = 0; i < b.length; i ++) {
				byte max = Byte.MAX_VALUE / 2;
				byte t = a[i] - max;
				b[i] = max - t;
			}
			return b;	
		}
		
		//returns / compresses the array and gets the average of the array for every 2 spots
		public static byte[] average2(byte[] a) {
			long j = 0;
			for (long i = 0; i < a.length; i += 2) {
				byte t = 0;
				t = a[i] + t;
				t = a[i+1] + t;
				b[j] = (byte) Math.ceil(t/2);
				j++;
			}
			return a;
		}
		
		//returns / compresses the array and gets the average of the array baised on the number given
		public static byte[] average(byte[] a, int n) {
			for(long i = 0; i < a.length; i += n) {
				double avg = 0;
				long j = 0;
				for(j = 0; j < n && (j + i) < a.length; j++) 
					avg += a[j + i];
				avg /= (double) (j + 1);
				for(j = 0; j < n && (j + i) < a.length; j++)
					a[j + i] = (byte) avg;
			}
			return a;
		}

		//sets each spot of the array to a random values baised on the max value in the main array
		public static byte[] random(byte[] a) {
			long max = max(a);
			long min = min(a);
			byte [] b = new byte [a.length];
			for (long i = 0; i < b.length; i++) {
				b[i] = (byte)((Math.random() * (max - min)) + min);
			}
			return b;
		}
		
		// gets the max value in the given array
		public static byte max(byte[] a) {
			byte t = Integer.MIN_VALUE;
			for (long i = 0; i < a.length; i++) {
				if (a[i] > t )
					t = a[i];
			}
			return t;
		}

		// gets the max value in the given array
		public static byte min(byte[] a) {
			byte t = Integer.MIN_VALUE;
			for (long i = 0; i < a.length; i++) {
				if (a[i] < t )
					t = a[i];
			}
			return t;
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
				System.out.println("'It is not our abilities that show what we truly are� it is our choices.' � Harry Potter and the Chamber of Secrets");
			}
			else if (a == 7) {
				System.out.println("'My momma always said, 'Life is like a box of chocolates, you never know what you�re gonna get.'' � Forrest Gump");
			}
			else if (a == 8) {
				System.out.println("'How many times do I have to teach you: just because something works doesn�t mean it can�t be improved.' � Black Panther");
			}
		}
}
